package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlCateDao;

@Controller
public class AdminCateInsertController {
	
	private final String command = "/insertAlCate.ad";
	private String gotoPage = "redirect:/cateList.ad";
	
	@Autowired
	private AlCateDao alCateDao;
	
	@RequestMapping(command)
	public String insert(@RequestParam("cate") String cate) {
		
		alCateDao.insertAlCate(cate);
		
		return gotoPage;
	}

}
