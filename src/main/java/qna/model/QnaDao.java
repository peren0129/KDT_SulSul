package qna.model;

import java.util.ArrayList;
import java.util.HashMap;
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
		lists = sqlSessionTemplate.selectList(namespace+".getAllData", map, rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace+".getTotalCount", map);
		return totalCount;
	}

	public void updateReadcount(String num) {
		sqlSessionTemplate.update(namespace+".addReadcount",num);
	}
	
	public void insertData(QnaBean qna) {
		sqlSessionTemplate.insert(namespace+".insertData", qna);
	}

	public QnaBean getData(String num) {
		QnaBean qna = sqlSessionTemplate.selectOne(namespace+".getData", num);
		return qna;	
	}
	
	public void updateData(QnaBean qna) {
		int cnt = sqlSessionTemplate.update(namespace+".updateData", qna);
	}

	public int deleteData(String num) {
		System.out.println("deleteData 2");
		int cnt = sqlSessionTemplate.delete(namespace+".deleteData",num);
		System.out.println("deleteData 3");
		return cnt;
	}
	

// ----------- 리뷰  ---------------
	public List<QcommentBean> getComment1(String ref) {
		List<QcommentBean> list = new ArrayList<QcommentBean>();

		list = sqlSessionTemplate.selectList(namespace + ".getComment");
		System.out.println("------------ review dao--------");
		System.out.println(ref);
		for (QcommentBean review : list) {
			System.out.println(review);
		}
		return list;
	}

	public List<QcommentBean> getComment(String num) {
		List<QcommentBean> list = sqlSessionTemplate.selectList(namespace + ".getComment", Integer.parseInt(num));
		return list;
	}
	
	public void insertComment(QcommentBean comment) {
		sqlSessionTemplate.insert(namespace + ".insertComment", comment);
	}
	
	public int updateComment(int pnum) {
		return sqlSessionTemplate.insert(namespace + ".updateComment", pnum);
	}
	
	public int selectRecomm(int pnum) {
		return sqlSessionTemplate.selectOne(namespace + ".selectRecomm", pnum);
	}
	
	public int checkBuyFlag(String memberID, int productID) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberID", memberID);
		map.put("productID", Integer.toString(productID));
		
		return sqlSessionTemplate.selectOne(namespace + ".SelectCheckbuyFlag", map);
	}
	
	public int checkDuplecateReview(String memberID, int productID) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberID", memberID);
		map.put("productID", Integer.toString(productID));
		
		return sqlSessionTemplate.selectOne(namespace + ".CheckDuplecateReview", map);
	}

// ----------- 리뷰 끝 ---------------
	
	
} 