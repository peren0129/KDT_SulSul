package mall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {
	
	private final String command = "/myPage.mall";
	private String getPage = "/myPage";
	//private String gotoPage ="redirect:/order.mall";
	//private String gotoPage ="/shopList";
	
	@RequestMapping(command)
	public String mypage(HttpServletResponse response,
						HttpSession session
						)throws IOException {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			//�α��ξ��ϸ� �ϵ���
			if(session.getAttribute("loginInfo") == null) {
				writer.println("<script> alert('�α��� �� �̿밡���մϴ�');  history.go(-1);  </script>");
				writer.flush(); //alert�� ��������� �� 
				session.setAttribute("destination", "redirect:/order.mall");
				return getPage;
		
	}
			return getPage; //���⼭ order.mall�� ���� ����Ʈ �� �Ǵ°ſ��� ������..
		
	
}
}
