package qna.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class QnaBean {
	private String num;
	
	private String writer; //작성자, members의 num과 연결
	private String cate1; //구매자/판매자
	private String cate2; //비밀글/전체공개
	private String cate3; //회원/정보관리,배송,반품/환불/교환/AS,영수증/증빙서류,상품/이벤트,키타
	
	@NotEmpty(message = "제목을 입력해주세요.")
	private String subject;
	private String image;
	private String checkimage; //자동 등록 방지 이미지
	private String content;
	private Timestamp reg_date;
	private String readcount;
	private String ref; // =num
	private String re_step; //최신순, 낮은 번호가 최신
	private String re_level; //원글0, 답글1, 답답글2
	private String reply;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCate1() {
		return cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}
	public String getCate2() {
		return cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}
	public String getCate3() {
		return cate3;
	}
	public void setCate3(String cate3) {
		this.cate3 = cate3;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCheckimage() {
		return checkimage;
	}
	public void setCheckimage(String checkimage) {
		this.checkimage = checkimage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getRe_step() {
		return re_step;
	}
	public void setRe_step(String re_step) {
		this.re_step = re_step;
	}
	public String getRe_level() {
		return re_level;
	}
	public void setRe_level(String re_level) {
		this.re_level = re_level;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
