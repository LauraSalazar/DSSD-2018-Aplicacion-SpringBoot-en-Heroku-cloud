package com.heroku.ventaOnLine.heroku.ventaOnLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import coupon.dto.CouponDTO;
import coupon.services.CouponService;

@RestController
public class CouponResource {
	
	CouponService couponService;

	public CouponResource() {
		super();
		couponService = new CouponService();
	}
	
	 @RequestMapping(value="/coupons",produces = "application/json" )
	 public List<CouponXml> coupons() {

	      List<CouponXml> cuponesXml = null;
	      
	      List<CouponDTO> couponsDTO ; 
	      
	      couponsDTO = couponService.getCoupons();
	      
	      if (couponsDTO != null) {
	    	  CouponXml couponXml;
	    	  cuponesXml = new ArrayList<CouponXml>();
	    	  for(CouponDTO cDTO: couponsDTO) {
	    		  couponXml = new CouponXml();
	    		  couponXml.setId(cDTO.getId());
	    		  couponXml.setNumber(cDTO.getNumber());
	    		  couponXml.setUsed(cDTO.getUsed());
	    		  cuponesXml.add(couponXml);
	    	  }
	      }
	      
	      return cuponesXml;
	   
	  }
	 
	 @RequestMapping(value="/addCoupon/{number}",produces = "application/json" )
	 public String addCoupon(@PathVariable("number") String number) {

	      CouponDTO couponDTO = couponService.addCoupon(number);
	      String response = null;
	      if (couponDTO != null) {
	    	  response = " Se ha agregado el cupon con id " + couponDTO.getId();
	      }
	      else {
	    	  response = " No se ha podido crear el cupon";
	      }
	      return response;
	   
	  }
}
