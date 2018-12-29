/**
 * 
 */
package org.hanamant.person.model;

/**
 * @author hguggari
 *
 */
public class Person {

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + "]";
	}

	static int idCreate = 0;
	/**
	 * 
	 */
	public Person() {
		this.id = idCreate++;
	}
	
	private Integer id;
	private String name;
	private String address;
	private String mobile;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}