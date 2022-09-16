package admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import alcohol.model.AlCateBean;
import alcohol.model.AlCateDao;
import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import utility.Paging;

@Controller
public class AdminAlcoholInsertController {
	
	private final String command = "/insertAlcohol.ad";
	private String gotoPage = "redirect:/alcoholList.ad";
	private String getPage = "/alcoholList";
	
	@Autowired
	private AlcoholDao alcoholDao;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	private AlCateDao alCateDao;
	
	@RequestMapping(command)
	public String insert(@ModelAttribute("alcohol") @Valid AlcoholBean alcohol, BindingResult result,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			HttpServletRequest request,
			Model model,
			HttpServletResponse response) throws IOException {
		
		if(result.hasErrors()) {
			
			/*
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=UTF-8"); //�������� �������� �ѱ�ó��

			pw.println("<script>");
			pw.println("alert('ī�װ��� ������ �ּ���');");
			pw.println("</script>");
			pw.flush(); // �Ⱦ��� �ȶ�
			*/ //���� ���� �������� �ȳ���
			
			//�˻���
			Map<String, String> map = new HashMap<String, String>();
			map.put("whatColumn", whatColumn);
			map.put("keyword", "%"+keyword+"%");
			//System.out.println("whatColumn "+whatColumn);
			//System.out.println("keyword "+keyword);
			
			//����¡
			int totalCount = alcoholDao.getTotalCount(map);
			String url = request.getContextPath()+"/"+command;
			
			Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword,null);
			
			//�ַ� ����Ʈ ��������
			List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
			lists = alcoholDao.getAllAlcohol(map,pageInfo);
			
			//�ַ� ī�װ� ��������
			List<AlCateBean> lists2 = new ArrayList<AlCateBean>();
			lists2 = alCateDao.getAllAlCate();
			
			model.addAttribute("lists", lists);
			model.addAttribute("lists2", lists2);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("totalCount", totalCount);
			
			return getPage;
			
		}
		
		System.out.println("AdminAlcoholInsertController");
		System.out.println(alcohol.getUpload());
		System.out.println(alcohol.getImage());
		
		//���� �ø���
		String path = application.getRealPath("/resources");
		System.out.println(path);
		
		MultipartFile multi = alcohol.getUpload(); //���� ����
		MultipartFile multi2 = alcohol.getUpload2(); //���� ����
		
		File file = new File(path+"/"+multi.getOriginalFilename());
		File file2 = new File(path+"/"+multi2.getOriginalFilename());
		
		try {
			multi.transferTo(file);
			multi2.transferTo(file2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		alcoholDao.insertAlcohol(alcohol);
		
		return gotoPage;
	}

}
