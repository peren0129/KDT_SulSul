package mall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlcoholBean;
import mall.cart.MyCartList;

@Controller
public class CartAddController {

	private final String command ="add.mall";
	private String getPage ="/mallList";
	private String gotoPage ="redirect:/list.mall";
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String add(@RequestParam(value="pageNumber",required = false) String pageNumber,
						HttpServletResponse response,
						Model model,
						HttpSession session) throws IOException{

			response.setContentType("text/html; charset=UTF-8");//response ������ ������ �Ѵ� //�������� �����Ϳ� �ѱ�ó��
			PrintWriter writer = response.getWriter(); //writer����ٸ��� Ÿ�� ���� ���	  
		
			if(session.getAttribute("loginInfo") == null) { //�α��� �������� 
				//session.setAttribute("destination", "redirect:/main.mall"); 
				writer.println("<script> alert('�α��� �� �̿밡���մϴ�');  history.go(-1);  </script>");
				writer.flush(); //alert�� ��������� �� 
			return "redirect:/login.mem";
		} else {
				MyCartList mycart = (MyCartList) session.getAttribute("mycart");
				System.out.println("mycart:"+mycart);
				
				if(mycart == null) {
					mycart = new MyCartList();
				}
				
				session.setAttribute("mycart", mycart);

			return gotoPage;
		}
	}
	
	//�󼼺���.jsp���� add.mall��û , ��ǰ��ȣ, ��������ȣ, �ֹ�����-��� bean�� ����.
	@RequestMapping(command)
	public String add(AlcoholBean alcohol,
						@RequestParam(value="pageNumber",required = false) String pageNumber,
						HttpSession session) { //setNum, setOderqty
		System.out.println("alcohol.getNum : "+alcohol.getNum());
		System.out.println("alcohol.getOrderqty : "+alcohol.getOrderqty()); //�����Ͽ��� ��������
		System.out.println("cartAddCon/image:"+alcohol.getImage()); //���ϸ� �ʷ�.jpg
		
		int num = Integer.valueOf(alcohol.getNum());
		int oqty = alcohol.getOrderqty();
		
	
		//�α��ξ��ص� �󼼺��� ���������� �ֹ��� �α����� �ؾ� �����ְ� ����� �ʹ�. 
		if(session.getAttribute("loginInfo") == null) { //�α��� �������� 
			session.setAttribute("destination", "redirect:/detail.al?num="+alcohol.getNum()+"&pageNumber="+pageNumber); 
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
	
			mycart.addOrder(num, oqty);			
			
			session.setAttribute("mycart", mycart);
			return gotoPage;
		}
		
		
	}
	
	
	
}
