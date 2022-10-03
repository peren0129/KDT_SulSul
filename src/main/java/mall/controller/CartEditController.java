package mall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alcohol.model.AlcoholBean;
import mall.cart.MyCartList;

@Controller
public class CartEditController {

	private final String command ="cartEdit.mall";
	private String gotoPage ="redirect:/list.mall";
	
	//�󼼺���.jsp���� add.mall��û , ��ǰ��ȣ, ��������ȣ, �ֹ�����-��� bean�� ����.
	@RequestMapping(command)
	public String add(	@RequestParam(value="num",required = true) int num,
						@RequestParam(value="oqty",required = true) int oqty,
						@RequestParam(value="pageNumber",required = false) String pageNumber,
						HttpSession session,
						HttpServletResponse response) throws IOException { //setNum, setOderqty

		System.out.println(num);
		System.out.println(oqty); //�����Ͽ��� ��������
		
		 response.setContentType("text/html; charset=UTF-8");//response ������ ������ �Ѵ� //�������� �����Ϳ� �ѱ�ó��
		 PrintWriter writer = response.getWriter(); //writer����ٸ��� Ÿ�� ���� ���
			MyCartList mycart = (MyCartList) session.getAttribute("mycart");
			System.out.println("Edit mycart:"+mycart);
			
//			if(mycart == null) {
//				mycart = new MyCartList();
//			}
	
			mycart.setEdit(num, oqty);
			
			session.setAttribute("mycart", mycart);
			 /*
			  writer.println("<script>alert('������ ����Ǿ����ϴ�.'); history.go(-1);  </script>"); 
			  writer.flush();
			�̰��ϸ� ���������ٰ� ������ ���ΰ�ħ�ؾ� �հ� �ݾ��� �����Ǵ�.. �̻���.. 
			 */				
			return gotoPage;
		
	}
	
}
