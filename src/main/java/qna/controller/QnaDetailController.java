package qna.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import member.model.MemberBean;
import qna.model.QcommentBean;
import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaDetailController {
	
	private final String command = "detail.qna";
	private String getPage = "/detailForm";

	@Autowired
	QnaDao qnaDao;

//	@Autowired
//	BoardService boardService;
	
	@RequestMapping(value = command)
	public ModelAndView detail(@RequestParam("num") String num,
			@RequestParam(value="pageNumber",required = false) String pageNumber) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		ModelAndView mav = new ModelAndView();
		qnaDao.updateReadcount(num);
		QnaBean qna = qnaDao.getData(num);
		
		mav.addObject("qna",qna);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",qna.getNum());
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = "/comWrite.qna", method = RequestMethod.POST)
	public String comWrite(@RequestParam("num") String num, QcommentBean comment, RedirectAttributes rttr,
			HttpSession session, Model model) throws IOException {
		MemberBean member = (MemberBean) session.getAttribute("loginInfo");
		Date sqlDate = new Date(new java.util.Date().getTime());

		comment.setReg_date(sqlDate);
		comment.setWriter(member.getId());
 
		qnaDao.insertComment(comment);

		rttr.addAttribute("num", comment.getComnum());
		rttr.addAttribute("pageNumber", 1);

		return "redirect:/detail.qna";
		}
}


