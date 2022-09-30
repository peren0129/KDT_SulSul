package admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import order.model.OrderBean;
import order.model.OrderDao;
import utility.Paging;

@Controller
public class AdminOrderListController {
	
	private final String command = "/orderList.ad";
	private String getPage = "/orderList";
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(command)
	public String list(@RequestParam(value="pageNumber", required = false) String pageNumber,
					@RequestParam(value="whatColumn", required = false) String whatColumn,
					@RequestParam(value="keyword", required = false) String keyword,
					HttpServletRequest request, Model model) {
		/*
		OrderBean
		private int orderid; //�ֹ�(����)��ȣ
		private String memid; //ȸ����ȣ
		private String orderdate; //�ֹ� ����
		
		OrderDetailBean
		private int odid; // ����
		private int orderid; // �ֹ���ȣ
		private int num;  // ��ǰ��ȣ
		private int qty; //�ֹ� ����
		
		ShoppingInfo
		private int num;
		private String name;
	    private int price;
	    private int point;
	    private int qty;
	    private String image;
	    private int delivery;
	    private int pointAmount;
	    private int priceAmount; 
		*/
		
		//jsp�� jstl whatColumn/keyword�� ���� ����
		if(whatColumn.equals("1")) {
			whatColumn = "";
			keyword = "";
		}
		
		//���� ��ȸ
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date currentTime = new Date();
		String date = format.format(currentTime);
		String year = date.substring(0, 3);
		
		String origin = null;
		if(whatColumn.equals("month")) {
			origin = keyword;
			keyword = year+"%"+origin+"___";
		}
		
		
		//
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalcount = orderDao.getTotalCount(map);
		//System.out.println("totalcount "+totalcount);
		
		String url = request.getContextPath()+"/"+command;
		
		//�ٽ� �������� �� ���ڷ� �ȹٲ��ָ� ����¡�� ����������^^
		if(whatColumn.equals("month")) {
			keyword = origin;
		}
		
		Paging pageInfo = new Paging(pageNumber,"5",totalcount,url,whatColumn,keyword,null);
		
		List<ShoppingInfo> lists = new ArrayList<ShoppingInfo>();
		lists = orderDao.getAllOrderList(map,pageInfo);
		
		/*
		if(whatColumn.equals("month")) {
			keyword = origin;
		}
		*/

		model.addAttribute("lists", lists);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);
		
		
		return getPage;
	}

}
