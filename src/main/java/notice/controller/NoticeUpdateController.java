package notice.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class NoticeUpdateController {
	private final String command ="update.no";
	private String getPage = "/updateForm";
	private String gotoPage = "redirect:/detail.no";

	@Autowired
	private NoticeDao noticeDao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String update(Model model, @RequestParam("num") String num,
			@RequestParam(value="pageNumber", required=false) String pageNumber) {
		
		System.out.println("NoticeUpdateController_GET");
		NoticeBean notice = noticeDao.getData(num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("notice", notice);
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST) 
	public ModelAndView write(
			@ModelAttribute("board") @Valid NoticeBean notice, BindingResult result,
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			HttpServletResponse response) throws IOException {

		System.out.println("NoticeUpdateController_POST");
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		if(result.hasErrors()) { 
			mav.setViewName(getPage);
			return mav;
		}
		response.setContentType("text/html; charset=UTF-8"); //한글처리
		PrintWriter writer = response.getWriter(); //연결다리
		
		//아래 나중에 지우기
		System.out.println("NoticeUpdateController 1");
		noticeDao.updateData(notice);
		System.out.println("NoticeUpdateController 4");
		/* alert을 이렇게 띄우면 넘어가는 주소 인식이 안됨..
		writer.println("<script type='text/javascript'> alert('수정되었습니다.'); </script>");
		writer.flush();
		*/
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",notice.getNum());
		mav.setViewName(gotoPage);
		return mav;

		
		
	}
}
