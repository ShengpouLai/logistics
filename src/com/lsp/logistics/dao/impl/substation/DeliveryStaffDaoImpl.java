package com.lsp.logistics.dao.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.substation.DeliveryStaffDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.DeliveryStaffEntity;

public class DeliveryStaffDaoImpl extends BaseDaoImpl<DeliveryStaffEntity> implements DeliveryStaffDaoIfac{

	public DeliveryStaffDaoImpl() {
		super(DeliveryStaffEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DeliveryStaffEntity> findDeliveryStaff(
			String deliveryStaffName, Integer id) {
		
		String hql = "from DeliveryStaffEntity as d where ";
		if(deliveryStaffName.length() > 0){
			hql = hql + " d.deliveryStaffName = '" + deliveryStaffName + "' and ";
		}
		if(id != null){
			hql = hql + " d.substation_t.id = '" + id + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<DeliveryStaffEntity> findBySubstation(Integer id) {
		String hql = "from DeliveryStaffEntity as d where d.substation_t.id = " + id;
		return getHibernateTemplate().find(hql);
	}

}
