package qna.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("QnaDao")
public class QnaDao {
	
	private String namespace = "qna.model.Qna";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<QnaBean> getAllData(Paging pageInfo, Map<String, String> map) {
		List<QnaBean> lists = new ArrayList<QnaBean>(); 
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetAllData", map, rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace+".GetTotalCount", map);
		return totalCount;
	}

	public void insertData(QnaBean qna) {
		System.out.println("insert 2");
		sqlSessionTemplate.insert(namespace+".InsertData", qna);
		System.out.println("insert 3");
	}

	
	
	
	
	//getOneData
} 