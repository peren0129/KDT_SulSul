package notice.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaWriteController {

	private final String command = "/write.qna";
	private String getPage = "/writeForm";
	private String gotoPage = "redirect:/list.qna";

	@Autowired
	private QnaDao qnaDao;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String write(HttpSession session) {
		System.out.println("WriteController_GET");
		
		/*
		// 로그인하면 loginInfo session설정
		if(session.getAttribute("loginInfo") == null) { // 로그인 안했으면
			
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.mem"; // MemberLoginController
		}
		else { // 로그인했으면
		}
		}
		*/
		
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView write(@ModelAttribute("qna") @Valid QnaBean qna, BindingResult result,
			HttpServletRequest request) {
		System.out.println("WriteController_POST");
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			System.out.println("hasErrors : "+result.hasErrors());
			System.out.println("getErrorCount : "+result.getErrorCount());
			System.out.println("getAllErrors : "+result.getAllErrors());
			mav.setViewName(getPage);
			return mav;
		}
		
		MultipartFile multi = qna.getUpload();
		System.out.println("multi.getName():"+multi.getName());
		System.out.println("multi.getOriginalFilename():"+multi.getOriginalFilename());
		System.out.println("product.getImage():"+qna.getImage());
		
		qna.setReg_date(new Timestamp(System.currentTimeMillis())); 
		
		System.out.println("insert 1");
		qnaDao.insertData(qna);
		System.out.println("insert 4");
		
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath:"+uploadPath);
		
		File file = new File(uploadPath+"/"+multi.getOriginalFilename());
		try {
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mav.setViewName(gotoPage);
		return mav;
	}
}