package mall.cart;

import java.util.HashMap;
import java.util.Map;

import alcohol.model.AlcoholBean;

public class MyCartList { //��ٱ���
	
	private Map<Integer,Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer,Integer>();
	}

	public void addOrder(int num, int oqty) {
		
		if(orderlists.containsKey(num)) {
			int orgqty=orderlists.get(num); 
			orderlists.put(num, orgqty+oqty);
		}else {
			orderlists.put(num, oqty);
		}
		
	}

	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}

	public void setEdit(int num, int oqty) {
	
		if(orderlists.containsKey(num)) {
			orderlists.put(num, oqty);  
				//break;
			}
	}

	
	public void removeProduct(int num,AlcoholBean alcohol) {//��ٱ����� ��ǰ ����
		//��ٱ���  7�� �����ϰڴ�. 
		//0 : 12����ǰ 1���ֹ� ���� ����ִ� =>5���ֹ�
		//1 : 4����ǰ 3���ֹ� =>2���ֹ�
		//2 : 7�� 3���ֹ�
		
		if(orderlists.containsKey(num)) {
			orderlists.remove(num); //������ �����ؾߵǴµ�..
			
			//lists.removeElement(pb); //���� �����ִ� pb��ǰ�� ������
			}	
	}//removeProduct
	
	public void removeAllProduct() {//��ٱ����� ��ǰ�� �����ϰ� ����...���! ��ǰ ���� 
				orderlists.clear();
				//lists.removeAllElements();		

	}//removeAllProduct   


	
	
}//��
	
