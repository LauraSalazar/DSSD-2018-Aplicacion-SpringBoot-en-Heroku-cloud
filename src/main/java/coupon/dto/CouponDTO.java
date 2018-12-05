package coupon.dto;

import coupon.model.Coupon;

public class CouponDTO {
	
	private Integer id;
	private String number;
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
	public CouponDTO(Integer id, String number, Boolean used) {
		super();
		this.id = id;
		this.number = number;
		this.used = used;
	}
	
	public CouponDTO(Coupon coupon) {
		this.id = coupon.getId();
		this.number = coupon.getNumber();
		this.used = coupon.getUsed();
	}

}
