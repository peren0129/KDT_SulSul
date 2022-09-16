package member.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	private int num;
	
	@NotBlank(message="닉네임을 적어주세요.")
	private String name;
	
	@NotBlank(message="아이디를 적어주세요.")
	private String id;
	
	@NotBlank(message="비밀번호를 적어주세요.")
	private String password;
	
	private String email;
	
	@NotBlank(message="성인인증을 해주세요.")
	private String rrn1;
	private String rrn2;
	
	@NotBlank(message="핸드폰 번호를 완성 해주세요.")
	private String hp1;
	private String hp2;
	private String hp3;
	
	@NotBlank(message="주소를 완성 해주세요.")
	private String zipcode1;
	private String zipcode2;
	private String zipcode3;

	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRrn1() {
		return rrn1;
	}
	public void setRrn1(String rrn1) {
		this.rrn1 = rrn1;
	}
	public String getRrn2() {
		return rrn2;
	}
	public void setRrn2(String rrn2) {
		this.rrn2 = rrn2;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getZipcode1() {
		return zipcode1;
	}
	public void setZipcode1(String zipcode1) {
		this.zipcode1 = zipcode1;
	}
	public String getZipcode2() {
		return zipcode2;
	}
	public void setZipcode2(String zipcode2) {
		this.zipcode2 = zipcode2;
	}
	public String getZipcode3() {
		return zipcode3;
	}
	public void setZipcode3(String zipcode3) {
		this.zipcode3 = zipcode3;
	}
	
	

}
