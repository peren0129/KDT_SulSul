package qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qna.model.QcommentBean;
import qna.model.QcommentDao;

@Controller
public class QcommentController {
	
	private final String command = "/insertComment.qna";
	private String getPage = "redirect:/detail.qna";

	@Autowired
	QcommentDao qcoDao;
	
	@ModelAttribute("id")
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView insert(
			@ModelAttribute("qco") @Valid QcommentBean qco, BindingResult result,
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			HttpServletResponse response) throws IOException {
		System.out.println("QcommentController");
		System.out.println("pageNumber : "+pageNumber);

		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			System.out.println("hasErrors : "+result.hasErrors());
			System.out.println("getErrorCount : "+result.getErrorCount());
			System.out.println("getAllErrors : "+result.getAllErrors());
			mav.setViewName(getPage);
			return mav;
		}

		//qco.setReg_date(new Timestamp(System.currentTimeMillis())); 

		System.out.println("insert 1");
		qcoDao.insertComment(qco);
		System.out.println("insert 4");

		mav.addObject("pageNumber",pageNumber);
		mav.addObject("comnum",qco.getComnum());
		//mav.setViewName(getPage+"?pnum="+pnum);
		return mav;
	}
	
	@RequestMapping("/getCommentList")
	public List<QcommentBean> getCommentList(@RequestParam("pnum") String pnum) {
		System.out.println("pnum : "+pnum);
		QcommentBean qco = new QcommentBean();
		QcommentDao qdao = new QcommentDao();
		qco.setPnum(pnum);
		return qdao.getCommentList(qco);
		
	}
			
	
}
