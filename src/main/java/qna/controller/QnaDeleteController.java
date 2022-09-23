package qna.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaDeleteController {
	private final String command="delete.qna";
	private String getPage="redirect:/list.qna";
	
	@Autowired
	private QnaDao qnaDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public ModelAndView deleteProc(Model model, @RequestParam("num") String num,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();

		QnaBean qna = qnaDao.getData(num);
		
			String deletePath = servletContext.getRealPath("/resources/qna");
			File delFile = new File(deletePath+"/"+qna.getImage()); 
			delFile.delete();
		 
		
		//아래 나중에 잘 합쳐보자 ..
		int cnt = qnaDao.deleteData(num);
		response.setContentType("text/html; charset=UTF-8"); //한글처리
		PrintWriter writer = response.getWriter(); //연결다리
		
		/* alert을 이렇게 띄우면 넘어가는 주소 인식이 안됨..
		writer.println("<script type='text/javascript'> alert('삭제되었습니다.'); </script>");
		writer.flush();
		*/
		
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",qna.getNum());
		mav.setViewName(getPage);
		return mav;
/*
		//System.out.println(qna.로그인정보());		
		if(로그인이 되어있으면) {
			writer.println("<script type='text/javascript'> alert('삭제되었습니다.'); </script>");
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
