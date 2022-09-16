package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {

	public final String command="/login.mem";
	public String getPage="/memberLoginForm";
	public String gotoPage="redirect:/main.mall";

	@Autowired
	MemberDao memberDao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String login() {
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String login(MemberBean member,
			HttpServletResponse response,
			HttpSession session) throws IOException{

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		MemberBean login = memberDao.getMember(member.getId());

		if(login==null) {
			System.out.println("존재하지 않은 회원입니다.");

			writer.println("<script type='text/javascript'>");
			writer.println("alert('존재하지 않은 회원입니다.');");
			writer.println("</script>");
			writer.flush();

			return getPage;
		}
		else {
			if(member.getPassword().equals(login.getPassword())) {
				System.out.println("가입한 회원입니다.");
				session.setAttribute("loginInfo", login);

				String destination = (String)session.getAttribute("destination");
				return gotoPage; // 가입한 회원이면 메인창으로 가게 하자 일단은 list로
			}
			else {
				writer.println("<script type='text/javascript'>");
				writer.println("alert('비번이 일치하지 않습니다');");
				writer.println("</script>");
				writer.flush();

				return getPage;
			}
		}
	}
}
