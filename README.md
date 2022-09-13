	--qna																				
	drop sequence q_seq;									
	create sequence q_seq									
	start with 1									
	increment by 1									
	nocache;									

	drop table qna;									
	create table qna(									
	num number not null primary key,									
	writer varchar2(100), --작성자, members의 num과 연결									
	cateuser varchar2(100), --구매자/판매자									
	cateopen varchar2(100), --비밀글/전체공개									
	cate varchar2(100), --회원/정보관리,배송,반품/환불/교환/AS,영수증/증빙서류,상품/이벤트,기타									
	subject varchar2(100),									
	image varchar2(100),									
	checkimage varchar2(100), --자동 등록 방지 이미지									
	content varchar2(500),									
	reg_date date,									
	readcount number,									
	ref number,									
	re_step number,									
	re_level number,									
	reply varchar2(10)									
	);									

	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply)									
	values(q_seq.nextval,'kim','구매자','전체공개','상품/이벤트','상품 문의합니다.','언제 재입고 되나요?',sysdate,q_seq.currval,0,0,'no');									

	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply)									
	values(q_seq.nextval,'kim','구매자','전체공개','반품/환불/교환/AS','환불 신청합니다.','환불해 주세요',sysdate,q_seq.currval,0,0,'no');									

	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply)									
	values(q_seq.nextval,'kim','구매자','전체공개','상품/이벤트','문의드립니다.','유통기한이 언제까지 인가요?',sysdate,q_seq.currval,0,0,'no');									

	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply)									
	values(q_seq.nextval,'kim','구매자','비밀글','상품/이벤트','상품 문의합니다.','언제 재입고 되나요?',sysdate,q_seq.currval,0,0,'no');									


	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply) 
	values(q_seq.nextval,'asd','구매자','비밀글','배송','문의합니다.','빠른출고바랍니다.',sysdate,q_seq.currval,0,0,'no');								

	insert into qna(num,writer,cateuser,cateopen,cate,subject,content,reg_date,ref,re_step,re_level,reply) 
	values(q_seq.nextval,'kim1','구매자','전체공개','상품/이벤트','문의','유통기한 언제까지?',sysdate,q_seq.currval,0,0,'no');

	commit;

	col num for a6
	col writer for a10
	col cateuser for a10
	col cateopen for a10
	col cate for a10
	col subject for a10
	col image for a10
	col checkimage for a10
	col content for a10
	col reg_date for a10
	col ref for a10
	col re_step for a20
	col re_level for a20
	col reply for a20

	select * from qna;





	private String writer; //작성자, members의 num과 연결
	private String cateuser; //구매자/판매자
	private String cateopen; //비밀글/전체공개
	private String cate; //회원/정보관리,배송,반품/환불/교환/AS,영수증/증빙서류,상품/이벤트,키타
	private String subject;
	private String image;
	private String checkimage; //자동 등록 방지 이미지
	private String content;
	private String reg_date;
	private String readcount;
	private String ref; // =num
	private String re_step; //최신순, 낮은 번호가 최신
	private String re_level; //원글0, 답글1, 답답글2
	private String reply;
