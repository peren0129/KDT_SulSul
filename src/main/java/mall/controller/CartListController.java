package mall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import alcohol.model.AlcoholBean;
import alcohol.model.AlcoholDao;
import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import utility.Paging;

@Controller
public class CartListController {

	private final String command="list.mall";
	private final String getPage="/mallList";

	@Autowired
	AlcoholDao alcoholDao;

	@RequestMapping(command)
	public String cartList(HttpSession session, 
			Model model) {

		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		Map<Integer,Integer> map = mycart.getAllOrderLists();

		Set<Integer> keylist = map.keySet();
		System.out.println("keylist:"+keylist);

		List<ShoppingInfo> shopLists = new ArrayList<ShoppingInfo>();
		int totalPriceAmount = 0;
		int totalPointAmount = 0;
		int finalPrice= 0 ;
		int deliveryCost =0;

		//���̶� �߰�
		String productNum = "";
		for(Integer num : keylist) {

			if(productNum.equals("")) {
				productNum = String.valueOf(num);
			}

			AlcoholBean alcohol = alcoholDao.getAlcoholByNum(String.valueOf(num)); //bean���� int�ε� ��Ʈ������ �ѱ��

			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setNum(num);
			shopInfo.setName(alcohol.getName());
			shopInfo.setPrice(Integer.valueOf(alcohol.getPrice()));
			shopInfo.setPoint(Integer.valueOf(alcohol.getPoint()));
			shopInfo.setQty(map.get(num));
			shopInfo.setImage(alcohol.getImage());
			shopInfo.setDelivery(Integer.valueOf(alcohol.getDelivery()));  

			int pointAmount = Integer.valueOf(alcohol.getPoint())*map.get(num);
			shopInfo.setPointAmount(pointAmount);

			int priceAmount = Integer.valueOf(alcohol.getPrice())*map.get(num);
			shopInfo.setPriceAmount(priceAmount);

			totalPriceAmount += priceAmount;
			totalPointAmount += pointAmount;

			deliveryCost = Integer.valueOf(alcohol.getDelivery()); 
			if(totalPriceAmount >= 30000 ) {
				deliveryCost = 0;
			}else {
				deliveryCost = 3000;
			}

			finalPrice = totalPriceAmount+deliveryCost; //����Ʈ�� ���������! -totalPointAmount
			shopLists.add(shopInfo);
		}

		System.out.println("CartListController");
		System.out.println("productNum "+productNum);

		//��ǰ��õ
		//��ٱ��� �� �� ��ǰ�� ���� ��õ
		if( ! productNum.equals("")) {
			AlcoholBean product = alcoholDao.getAlcoholByNum(productNum);
			String cate = product.getCategory();

			System.out.println("product.getName() "+product.getName());
			System.out.println("product.getCategory() "+product.getCategory());

			String recommand = "";
			if(cate.contains("������")) {
				recommand = "��/�";
			}else if(cate.contains("��ť��")) {
				recommand = "������ǰ";
			}else if(cate.contains("���ɸ�")) {
				recommand = "�Ǿ";
			}else if(cate.contains("������")) {
				recommand = "����ǰ";
			}else if(cate.contains("�Ǿ")) {
				recommand = "���ɸ�";
			}else if(cate.contains("�߰���")) {
				recommand = "������";
			}else if(cate.contains("����ǰ")) {
				recommand = "������";
			}else if(cate.contains("������ǰ")) {
				recommand = "��ť��";
			}else if(cate.contains("��/�")) {
				recommand = "������";
			}

			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("whatColumn", "category");
			map2.put("keyword", "%"+recommand+"%");

			int totalcount = alcoholDao.getTotalCount(map2);
			Paging pageInfo = new Paging(null,"4",totalcount,null,null,null,null);

			List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
			lists = alcoholDao.getAllProduct(map2,pageInfo);

			model.addAttribute("product", product);
			model.addAttribute("lists", lists);
		}
		//


		model.addAttribute("shopLists", shopLists);
		model.addAttribute("totalPriceAmount", totalPriceAmount);
		model.addAttribute("totalPointAmount", totalPointAmount);
		model.addAttribute("finalPrice", finalPrice);
		model.addAttribute("deliveryCost", deliveryCost);

		return getPage;
	}

}
