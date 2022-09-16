package notice.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class NoticeBean {
	private String num;
	private String writer; 
	private String subject; 
	private String category; 
	private Timestamp reg_date;
	private int readcount;
	private String content;
	private String image;
	
	private MultipartFile upload;
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) { // upload=a.jpg X
		System.out.println("setUpload(MultipartFile upload)");
		this.upload = upload;
		System.out.println("setUpload upload:" + upload);
		System.out.println("upload.getName():"+upload.getName());
		System.out.println("upload.getOriginalFilename():"+upload.getOriginalFilename());
		setImage(upload.getOriginalFilename()); 
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	} 
	
}

/*
	create table notice(				
		num number not null primary key,			
		writer varchar2(50) not null,		
		subject varchar2(100) not null,	
		cate varchar2(50) not null, -- radio			
		reg_date date default sysdate,			
		readcount number default 0, -- 조회수			
		content varchar2(500),
		image varchar2(500) 
	);				
*/