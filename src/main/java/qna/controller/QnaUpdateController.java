package qna.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaUpdateController {

	private final String command ="update.bd";
	private String getPage = "/updateForm";
	private String gotoPage = "redirect:/list.bd";

	@Autowired
	private QnaDao qnaDao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String update(@RequestParam("num") String num,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Model model) {

		QnaBean qna = qnaDao.getData(num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("qna", qna);
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST) 
	public String write(
			@ModelAttribute("board") @Valid QnaBean qna, 
			BindingResult result,
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			HttpServletRequest request, Model model){

		if(result.hasErrors()) {
			model.addAttribute("pageNumber", pageNumber);
			return getPage;
		}

		model.addAttribute("pageNumber", pageNumber);
		return gotoPage; 
	}








}
