package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;

@Controller
public class CartCalculateController {

	private final String command ="calculate.mall";
	private final String gotoPage ="redirect:/order.mall";  //redirect:/list.prd"; //�����Ϸ��Ŀ� ����ڸ�����������? �ϴ��ֹ��������� �ֹ���ȣ ������ ������?
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AlcoholDao alcoholDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String calculate(HttpSession session, Model model) {
		
		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		
		Map<Integer,Integer> map = mycart.getAllOrderLists();
		
		Set<Integer> keylist = map.keySet();
		System.out.println("calculate keylist:"+keylist);
		
		MemberBean member= (MemberBean) session.getAttribute("loginInfo");
		System.out.println("calulate�ֹ���:"+member.getId());
		orderDao.insertData(member.getId()); //ȸ�����̵� �ֹ���, ��� �ֹ��ص� �� �ֹ��ڷ�!
		
		int orderid = orderDao.getMaxOrderid(); //�ֱ� ��ٱ��Ͽ� �ְ� �ֹ������� ���� ū id����.
		System.out.println("���� ū orderid:"+orderid);
		
		for(Integer num : keylist) {
			OrderDetailBean orderdetail = new OrderDetailBean();
			orderdetail.setOrderid(orderid); //�ֹ���ȣ�̴� odid�� �������ϻ�
			orderdetail.setNum(num);
			orderdetail.setQty(map.get(num));
			
			System.out.println("�����ϱ�-orderid;"+orderdetail.getOrderid());
			System.out.println("num;"+orderdetail.getNum());
			System.out.println("Qty;"+orderdetail.getQty());
			
		orderDetailDao.insertData(orderdetail); //���� ������� ���� ������ ���������Ͽ� ��������
		
		System.out.println("�����ΰ�");
		
		alcoholDao.updateStock(num,map.get(num)); //����������
		
		
		System.out.println("!!!!!!");
		
		//���ݿ� 10% ȸ������Ʈ ����
		AlcoholBean alcohol = alcoholDao.getAlcoholByNum(String.valueOf(num));
		
		System.out.println("���� "+alcohol.getName());
		
		double mpoint = orderdetail.getQty()*Double.valueOf(alcohol.getPrice())*0.01;
		memberDao.updateMpoint(member.getId(),mpoint);
		
		}//for
		
		session.removeAttribute("mycart");
		return gotoPage;
		
	}
	
}
