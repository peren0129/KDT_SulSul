package alcohol.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("alcoholDao")
public class AlcoholDao {
	
	private String namespace = "alcohol.model.Alcohol";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertAlcohol(AlcoholBean alcohol) {
		sqlSessionTemplate.insert(namespace+".InsertAlcohol", alcohol);
	}
	
	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace+".GetTotalCount1",map);
		return totalCount;
	}

	public List<AlcoholBean> getAllAlcohol(Map<String, String> map, Paging pageInfo) {
		//페이징
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetAllAlcohol",map,rowBounds);
		return lists;
	}

	public AlcoholBean getAlcoholByNum(String num) {
		AlcoholBean alcohol = sqlSessionTemplate.selectOne(namespace+".GetAlcoholByNum", num);
		return alcohol;
	}

	public void updateAlcohol(AlcoholBean alcohol) {
		sqlSessionTemplate.update(namespace+".UpdateAlcohol", alcohol);
		
	}

	public void deleteAlcohol(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteAlcohol", num);
		
	}
	
	//메인페이지
	public List<AlcoholBean> getNewAlcohol() {
		List<AlcoholBean> lists = new ArrayList<AlcoholBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetNewAlcohol");
		return lists;
	}




}
