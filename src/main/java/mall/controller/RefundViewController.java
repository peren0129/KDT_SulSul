package mall.controller;

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
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;

@Controller
public class RefundViewController {
	
	private final String command ="refund.mall";
	private final String getPage="redirect:/order.mall";
	
	//�ֹ��� ��������� ��ٱ��� ���̺� ������ �������ϰ� ��,����Ʈ,��� ���� ? ����Ʈ ȸ��! 
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AlcoholDao alcoholDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String refund(@RequestParam(value="orderid",required = false) int orderid,
							HttpSession session, Model model) {
		
		MemberBean member= (MemberBean) session.getAttribute("loginInfo");
		System.out.println("refund �ֹ���:"+member.getId());

		System.out.println("refund �ֹ���ȣ:"+orderid);
		//01.�ֹ���ȣ ������ �ֹ���� ������Ʈ
		orderDao.orderCancle(orderid);

		//02.�����ߴ� ������ + �ϰ� ����Ʈ - �ؾߵ�...
		//orderDao.getOrder(orderid);			
		List<OrderDetailBean> details = orderDetailDao.selectOrderDetail(orderid); //���� ������� ���� ������ ���������Ͽ� ��������	
		for(OrderDetailBean detail : details) {
			int anum =detail.getNum();
			detail.getOdid();
			detail.getOrderid();
			detail.getQty();
		
		System.out.println("detail.getNum();"+detail.getNum()+","+anum);
		System.out.println("detail.getOdid();"+detail.getOdid());
		System.out.println("detail.getOrderid();"+detail.getOrderid());
		System.out.println("detail.getQty();"+detail.getQty());
		
		alcoholDao.updateStock2(anum,detail.getQty());
		
		//���ݿ� 10% ȸ������Ʈ ���̳ʽ�
		AlcoholBean alcohol = alcoholDao.getAlcoholByNum(String.valueOf(anum));
		double mpoint = detail.getQty()*Double.valueOf(alcohol.getPrice())*0.01;
		memberDao.updateMpoint2(member.getId(),mpoint);
		}
		return getPage;		

	}
	
}			
		
