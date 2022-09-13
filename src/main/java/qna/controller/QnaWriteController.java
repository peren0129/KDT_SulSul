package qna.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qna.model.QnaBean;
import qna.model.QnaDao;

@Controller
public class QnaWriteController {

	private final String command = "/write.qna";
	private String getPage = "/writeForm";
	private String gotoPage = "redirect:/list.qna";

	@Autowired
	private QnaDao qnaDao;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String write() {
		System.out.println("WriteController_GET");
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String write(@ModelAttribute("qna") @Valid QnaBean qna,
			HttpServletRequest request, BindingResult result) {
		System.out.println("WriteController_POST");

		if(result.hasErrors()) {
			return getPage;
		}

		qna.setReg_date(new Timestamp(System.currentTimeMillis())); 
		System.out.println("insert 1");
		qnaDao.insertData(qna);
		System.out.println("insert 4");
		return gotoPage;
	}

}
