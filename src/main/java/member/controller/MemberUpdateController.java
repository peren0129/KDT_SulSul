package member.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {
	
	private final String command="update.mem";
	private String getPage="/memberUpdateForm";
	private String gotoPage="redirect:/list.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("num") String num,
			@RequestParam("pageNumber") String pageNumber) {
			
		ModelAndView mav = new ModelAndView();
		MemberBean mb = memberDao.selectMemberByNum(num);
		mav.addObject("member",mb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		System.out.println("컨트롤러 mav"+mav);
		
		return mav;
	}
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String update(
			@ModelAttribute("member") @Valid MemberBean mb,
			BindingResult result,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("pageNumber",pageNumber);
			
			System.out.println("컨트롤러getPage"+getPage);
			return getPage;
			
		}
		memberDao.updateMember(mb);
		model.addAttribute("pageNumber",pageNumber);
		
		System.out.println("컨트롤러gotoPage"+gotoPage);
		return gotoPage;
	}

}
