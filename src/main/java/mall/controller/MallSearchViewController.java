package mall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import utility.Paging;

@Controller
public class MallSearchViewController {
	
	private final String command = "/mallSearchView.mall";
	private String getPage = "/mallSearchView";
	
	@Autowired
	private AlcoholDao alcoholDao;
	
	@RequestMapping(command)
	public String view(
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			Model model, HttpServletRequest request) {

		//검색어
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		System.out.println("whatColumn "+whatColumn);
		System.out.println("keyword "+keyword);

		//페이징
		int totalCount = alcoholDao.getTotalCount(map);
		String url = request.getContextPath()+"/"+command;
	
		Paging pageInfo = new Paging(pageNumber,"8",totalCount,url,whatColumn,keyword,null);

		//리스트
		List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
		lists = alcoholDao.getAllAlcohol(map,pageInfo);

		model.addAttribute("lists", lists);
		model.addAttribute("pageInfo", pageInfo);

		return getPage;
	}

}
