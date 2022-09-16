package admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import alcohol.model.AlCateBean;
import alcohol.model.AlCateDao;

@Controller
public class AdminCateListController {
	
	private final String command = "/cateList.ad";
	private String getPage = "/cateList";
	
	@Autowired
	private AlCateDao alCateDao;

	
	@RequestMapping(command)
	public String list(Model model) {
		
		List<AlCateBean> allists = new ArrayList<AlCateBean>();
		allists = alCateDao.getAllAlCate();
		
		model.addAttribute("allists" ,allists);	
		
		return getPage;
	}

}
