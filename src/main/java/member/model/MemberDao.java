package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import utility.Paging;

@Component("MemberDao")
public class MemberDao {
	
	String namespace="member.model.Member";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getTotalCount(Map<String, String> map) {
		int result = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		
		System.out.println("GetTotalCount"+result);
		return result;
	}

	public List<MemberBean> getMemberList(Paging pageInfo, Map<String, String> map) {
		List<MemberBean> lists=new ArrayList<MemberBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists=sqlSessionTemplate.selectList(namespace+".GetMemberList",map,rowBounds);
		
		return lists;
	}

	public int memberInsert(MemberBean member) {
		int cnt = sqlSessionTemplate.insert(namespace+".RegisterMember",member);
	
		System.out.println("Dao cnt:"+cnt);
		return cnt;
	}

	public int Idcheck(String inputid) {
		int result = -1;
		result = sqlSessionTemplate.selectOne(namespace+".IdCheck",inputid);
		return result;
	}

	public MemberBean getMember(String id) {
		MemberBean mbean = null;
		mbean = sqlSessionTemplate.selectOne(namespace+".GetMember", id);
		return mbean;
	}

	public MemberBean selectMemberByNum(String num) {
		MemberBean mb = sqlSessionTemplate.selectOne(namespace+".GetMemberDetail",num);
		return mb;
	}

	public void updateMember(MemberBean mb) {
		int cnt = sqlSessionTemplate.update(namespace+".UpdateMember",mb);
		System.out.println("업데이트 Dao"+cnt);
	}

	public int memberDelete(String num) {
		int cnt = sqlSessionTemplate.delete(namespace+".DeleteMember",num);
		System.out.println("deleteDao cnt:::"+cnt);
		return cnt;
	}

	public MemberBean getMemberById(String name,String email) {
		MemberBean mb = new MemberBean();
		mb.setName(name);
		mb.setEmail(email);
		System.out.println("아디찾1Dao:"+mb);
		mb = sqlSessionTemplate.selectOne(namespace+".GetMemberById",mb);
		System.out.println("아디찾2Dao:"+mb);
		return mb;
	}
	
}
