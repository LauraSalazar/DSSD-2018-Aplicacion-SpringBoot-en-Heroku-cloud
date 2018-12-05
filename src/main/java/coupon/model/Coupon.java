package coupon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="coupons")
public class Coupon {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="number")
	private String number;
	@Column(name="used")
	private Boolean used;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Coupon(Integer id, String number, Boolean used) {
		super();
		this.id = id;
		this.number = number;
		this.used = used;
	}
	

	public Coupon(){

	}
}
