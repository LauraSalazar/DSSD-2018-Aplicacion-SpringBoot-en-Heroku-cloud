package coupon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import coupon.dto.CouponDTO;
import coupon.model.Coupon;



@Repository
public class CouponDAO {
	private EntityManagerFactory emFactory;
	private EntityManager entityManager;
	
	public CouponDAO(){
		super();
		emFactory = Persistence.createEntityManagerFactory("ventaonline");
		entityManager = emFactory.createEntityManager();
	}
	
	public EntityManagerFactory getEmFactory() {
		return emFactory;
	}

	public void setEmFactory(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<CouponDTO> getCoupons() {
		List<CouponDTO> couponsDTO;
		String query = "from coupons ";
		try {
		@SuppressWarnings("unchecked")
		List<Coupon> coupons = (List<Coupon>)this.getEntityManager().createQuery(query).getResultList();
		couponsDTO = new ArrayList<CouponDTO>();
		for(Coupon a : coupons){
			couponsDTO.add(new CouponDTO(a));
		}
		}
		catch(NoResultException e) {
			return null;
		}
		return couponsDTO;
	
	}
	
	@Transactional
	public CouponDTO createCoupon(String number) {

		Coupon coupon = new Coupon();
		coupon.setNumber(number);
		coupon.setUsed(false);
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(coupon);
		this.getEntityManager().getTransaction().commit();
		
		return new CouponDTO(coupon);
	}
	
	@Transactional
	public CouponDTO isValid(String number) {

		CouponDTO couponDTO = null;
		String query = "from coupons c where c.number = :number and c.used = 'f' ";
		
		try {
		if (this.findByNumber(number) != null) {

		Coupon coupon = (Coupon)this.getEntityManager().createQuery(query).setParameter("number", number).getSingleResult();

		if (coupon != null) {
			couponDTO = new CouponDTO(coupon);
		}
		}}
		catch(NoResultException e) {
			return null;
		}
	
		return couponDTO;
		
	}
	
	@Transactional	
	public Coupon findByNumber(String number) {
		
		Coupon cupon = new Coupon();
		String query = "from coupons c where c.number = :number and c.used = 'f' ";
		System.out.println("Antes de ejecutar la consulta del findByNumber" + cupon);

		try {
		cupon = (Coupon)this.getEntityManager().createQuery(query).setParameter("number", number).getSingleResult();
		System.out.println("Despues de ejecutar la consulta" + cupon);
		}
		catch(NoResultException e) {
			return null;
		}
		return cupon;
	}
	
	@Transactional
	public void update(Coupon coupon){	
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(coupon);
		this.getEntityManager().getTransaction().commit();
	}
	
	public CouponDTO usarCupon(String number) {
		
		Coupon coupon = this.findByNumber(number);
		coupon.setUsed(true);
		this.update(coupon);
		return new CouponDTO(coupon);
	}

}
