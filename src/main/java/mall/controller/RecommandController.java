package mall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import utility.Paging;

@Controller
public class RecommandController {
	
	private final String command = "/recommand.mall";
	private String getPage = "/recommand"; //��
	
	@Autowired
	private AlcoholDao alcoholDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String recommand1(@RequestParam("num") String num, Model model) {
		AlcoholBean product = alcoholDao.getAlcoholByNum(num);
		String cate = product.getCategory();
		
		String recommand = "";
		if(cate.contains("������")) {
			recommand = "��/�";
		}else if(cate.contains("��ť��")) {
			recommand = "������ǰ";
		}else if(cate.contains("���ɸ�")) {
			recommand = "�Ǿ";
		}else if(cate.contains("������")) {
			recommand = "����ǰ";
		}else if(cate.contains("�Ǿ")) {
			recommand = "���ɸ�";
		}else if(cate.contains("�߰���")) {
			recommand = "������";
		}else if(cate.contains("����ǰ")) {
			recommand = "������";
		}else if(cate.contains("������ǰ")) {
			recommand = "��ť��";
		}else if(cate.contains("��/�")) {
			recommand = "������";
		}
		
		System.out.println("recommand "+recommand);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", "category");
		map.put("keyword", "%"+recommand+"%");
		
		int totalcount = alcoholDao.getTotalCount(map);
		Paging pageInfo = new Paging(null,"4",totalcount,null,null,null,null);
		
		List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
		lists = alcoholDao.getAllProduct(map,pageInfo);
		
		model.addAttribute("product", product);
		model.addAttribute("lists", lists);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String recommand() {
		return getPage;
	}

}
