package com.lsp.logistics.service.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.substation.DeliveryStaffDaoIfac;
import com.lsp.logistics.entity.DeliveryStaffEntity;
import com.lsp.logistics.service.ifac.substation.DeliveryStaffServiceIfac;

public class DeliveryStaffServiceImpl implements DeliveryStaffServiceIfac {
	
	private DeliveryStaffDaoIfac deliveryStaffDao;

	public void setDeliveryStaffDao(DeliveryStaffDaoIfac deliveryStaffDao) {
		this.deliveryStaffDao = deliveryStaffDao;
	}

	@Override
	public boolean saveDeliveryStaff(DeliveryStaffEntity deliveryStaff) {
		if(this.deliveryStaffDao.save(deliveryStaff)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<DeliveryStaffEntity> findAll() {
		return this.deliveryStaffDao.findAll();
	}

	@Override
	public DeliveryStaffEntity findById(Integer id) {
		return this.deliveryStaffDao.findById(id);
	}

	@Override
	public boolean update(DeliveryStaffEntity deliveryStaff) {
		if(this.deliveryStaffDao.update(deliveryStaff)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean delect(Integer id) {
		if(this.deliveryStaffDao.delete(id)){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public List<DeliveryStaffEntity> findDeliveryStaff(
			String deliveryStaffName, Integer id) {
		return this.deliveryStaffDao.findDeliveryStaff(deliveryStaffName, id);
	}

	@Override
	public List<DeliveryStaffEntity> findBySubstation(Integer id) {
		return this.deliveryStaffDao.findBySubstation(id);
	}
}
