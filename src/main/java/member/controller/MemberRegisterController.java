package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	public final String command = "/registerForm.mem";
	public String getPage = "/memberRegisterForm";
	public String gotoPage = "redirect:/list.mem";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String registerForm() {
System.out.println("ddddd");
		return getPage;
	}
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView register(
			@ModelAttribute("register") @Valid MemberBean member,
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println("123123");
			mav.setViewName(getPage);
			return mav;
		}
		memberDao.memberInsert(member);
		System.out.println("11111");
		mav.setViewName(gotoPage);
		
		System.out.println("insertController:"+mav);
		
		return mav;
	}
}
