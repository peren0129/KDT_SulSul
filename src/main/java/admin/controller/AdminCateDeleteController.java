package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlCateDao;

@Controller
public class AdminCateDeleteController {
	
	private final String command1 = "/deleteAlCate.ad";
	private String gotoPage = "redirect:/cateList.ad";

	@Autowired
	private AlCateDao alCateDao;

	
	@RequestMapping(command1)
	public String delete1(@RequestParam("num") String num) {
		
		alCateDao.deleteAlCate(num);
		return gotoPage;
	}

}
