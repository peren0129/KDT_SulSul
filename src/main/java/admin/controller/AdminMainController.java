package admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {
	
	private final String command = "/main.ad";
	private String getPage = "/main";
	
	@RequestMapping(command)
	public String main() {
		return getPage;
	}

}
