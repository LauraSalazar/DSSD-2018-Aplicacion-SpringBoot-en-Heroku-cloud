package coupon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

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

	
	public List<CouponDTO> getCoupons() {

		String query = "from coupons ";
		@SuppressWarnings("unchecked")
		List<Coupon> coupons = (List<Coupon>)this.getEntityManager().createQuery(query).getResultList();
		List<CouponDTO> couponsDTO = new ArrayList<CouponDTO>();
		for(Coupon a : coupons){
			couponsDTO.add(new CouponDTO(a));
		}
		return couponsDTO;
	
	}
	

}
