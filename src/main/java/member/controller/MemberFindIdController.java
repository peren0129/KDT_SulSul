package member.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberFindIdController {

	public final String command = "findId.mem";
	public String getPage = "/memberFindId";
	public String gotoPage = "redirect:/login.mem";

	@Autowired
	MemberDao memberDao;
	String msg;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String findId() {
		return getPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String findId(
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="email",required=true)String email,
			HttpServletResponse response,MemberBean member,HttpSession session) throws Exception {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		System.out.println("1");
		
		MemberBean login = memberDao.getMemberById(name,email);
		System.out.println(">>컨트롤러mb::"+login);
		
		if(login != null) {
			//msg = mb.getId();
			System.out.println("존재하지 않은 회원입니다");
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('회원님의 아이디는');"+login.getId()+"'입니다.'");
			writer.println("</script>");
			writer.flush();
			
			return getPage;
		}
		
		else {
			if(member.getId().equals(login.getId())) {
				System.out.println("가입한 회원입니다.");
				session.setAttribute("loginInfo", login);
				
				String destination = (String)session.getAttribute("destination");
				
				return destination;//?
			}else {
				writer.println("<script type='text/javascript'>");
				writer.println("alert('비번이 일치하지 않습니다');");
				writer.println("</script>");
				writer.flush();

				return getPage;
			}
			/*
			 * model.addAttribute("member",member);
			 * 
			 * return getPage;
			 */
		}
		
	}
}
