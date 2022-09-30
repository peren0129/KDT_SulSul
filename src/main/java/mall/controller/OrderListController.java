package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderListController {

	//�ٷΰ��� Ŭ���ϸ�  ->���� �������� ��Ʈ�ѷ� ->orderlist.jsp�� �̵�
	private final String command="/orderList.mall";
	private final String getPage="/orderList";
	private String gotoPage ="redirect:/odlist.mall";
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private AlcoholDao alcoholDao;
	
	@RequestMapping(command)
	public String add( //AlcoholBean alcohol,
				@RequestParam(value="num",required = true) int num,
				@RequestParam(value="orderqty",required = true) int orderqty,
						@RequestParam(value="pageNumber",required = false) String pageNumber,
						HttpSession session) { //setNum, setOderqty
		System.out.println("�ٷΰ���num : "+num);
		System.out.println("�ٷΰ���Orderqty : "+orderqty); //�����Ͽ��� ��������
		
		//�α��ξ��ص� �󼼺��� ���������� �ֹ��� �α����� �ؾ� �����ְ� ����� �ʹ�. 
		if(session.getAttribute("loginInfo") == null) { //�α��� �������� 
			session.setAttribute("destination", "redirect:/detail.al?num="+num+"&pageNumber="+pageNumber); 
			//�Ѿ���� ���� �־�� �ؼ� �󼼺���� ����! ��ȣ�� �������ѹ��� �Ѱ���� ������ �󼼺���� ����.
			return "redirect:/login.mem";
		}
		else { //�α��� ������
			//*����ǰ *�� ���� ��ٱ��ϰ� �ʿ�, + �ϳ��� ��ٱ��Ͽ� ������ǰ ��ƾ��Ѵ�.�ϳ������ ��� ������ �ٴҰŴ�.
			MyCartList mycart = (MyCartList) session.getAttribute("mycart");
			System.out.println("mycart:"+mycart);
			
			if(mycart == null) {
				mycart = new MyCartList();
			}
	
			mycart.addOrder(num, orderqty);			
			
			session.setAttribute("mycart", mycart);
			
			return gotoPage;
		}
		
		
		
		
	}
	
}

