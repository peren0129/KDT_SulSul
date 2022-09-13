package qna.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaDetailController {
	private final String command = "detail.qna";
	private String getPage = "/detailForm";

	@Autowired
	QnaDao qnaDao;

	@RequestMapping(value = command)
	public ModelAndView detail(@RequestParam("num") String num,
			@RequestParam("pageNumber") String pageNumber) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		QnaBean qna = qnaDao.getData(num);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("qna",qna);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}