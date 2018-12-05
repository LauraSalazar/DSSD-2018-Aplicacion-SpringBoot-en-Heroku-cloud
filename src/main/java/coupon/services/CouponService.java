package coupon.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coupon.dao.CouponDAO;
import coupon.dto.CouponDTO;


@Service
public class CouponService {
	
	CouponDAO couponDAO;
	
	public CouponService(){
		super();
		couponDAO = new CouponDAO();
	}
	
	public List<CouponDTO> getCoupons() {
	    
		return couponDAO.getCoupons();
	      
	}
	
	public CouponDTO addCoupon(String number) {
		return couponDAO.createCoupon(number);
	}
}
