package qna.controller;


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

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaUpdateController {
	private final String command ="update.qna";
	private String getPage = "/updateForm";
	private String gotoPage = "/detail.qna";

	@Autowired
	private QnaDao qnaDao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String update(Model model, @RequestParam("num") String num,
			@RequestParam(value="pageNumber", required=false) String pageNumber) {

		QnaBean qna = qnaDao.getData(num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("qna", qna);
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST) 
	public ModelAndView write(
			@ModelAttribute("board") @Valid QnaBean qna, BindingResult result,
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			HttpServletResponse response) throws IOException {

		ModelAndView mav= new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		if(result.hasErrors()) { 
			mav.setViewName(getPage);
			return mav;
		}
		//QnaBean loginCheck= qnaDao.getData(String.valueOf(qna.getNum()));
		//System.out.println(loginCheck.getUser());
		response.setContentType("text/html; charset=UTF-8"); //한글처리
		PrintWriter writer = response.getWriter(); //연결다리
		
		//아래 나중에 지우기
		qnaDao.updateData(qna);
		writer.println("<script type='text/javascript'> alert('수정되었습니다.'); </script>");
		writer.flush();
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",qna.getNum());
		mav.setViewName(gotoPage);
		return mav;
/*
		//System.out.println(qna.로그인정보());		
		if(로그인이 되어있으면) {
			writer.println("<script type='text/javascript'> alert('수정되었습니다.'); </script>");
			writer.flush();
			System.out.println("3");
			qnaDao.updateData(qna);
			mav.setViewName(getPage);
			return mav;
		} else { //로그인 x
			System.out.println("4");
			writer.println("<script type='text/javascript'> alert('로그인이 필요합니다.'); </script>");
			writer.flush();//방출해줘야함
			mav.addObject("pageNumber",pageNumber);
			mav.addObject("num",qna.getNum());
			mav.setViewName(gotoPage);
			return mav;
		}
*/
		
		
	}
}
