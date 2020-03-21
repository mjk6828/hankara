package model;

public class StudentVO {

	private String id;
	private String pass;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email; 
	private String zipcode;
	private String address1;
	private String address2;
	
	public StudentVO() {}
	public StudentVO(String id, String pass, String name, String phone1, String phone2, String phone3,
			String email, String zipcode, String address1, String address2) {
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.phone1=phone1;
		this.phone2=phone2;
		this.phone3=phone3;
		this.email=email;
		this.zipcode=zipcode;
		this.address1=address1;
		this.address2=address2;
	}
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getPass() {
		return pass;
	}
	public final void setPass(String pass) {
		this.pass = pass;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPhone1() {
		return phone1;
	}
	public final void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public final String getPhone2() {
		return phone2;
	}
	public final void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public final String getPhone3() {
		return phone3;
	}
	public final void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getZipcode() {
		return zipcode;
	}
	public final void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public final String getAddress1() {
		return address1;
	}
	public final void setAddress1(String address1) {
		this.address1 = address1;
	}
	public final String getAddress2() {
		return address2;
	}
	public final void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	
}
