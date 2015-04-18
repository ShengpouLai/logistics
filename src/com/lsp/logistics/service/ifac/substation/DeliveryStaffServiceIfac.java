package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.DeliveryStaffEntity;

public interface DeliveryStaffServiceIfac {
	
	public List<DeliveryStaffEntity> findAll();
	
	public boolean saveDeliveryStaff(DeliveryStaffEntity deliveryStaff);

	public DeliveryStaffEntity findById(Integer id);

	public boolean update(DeliveryStaffEntity deliveryStaff);

	public boolean delect(Integer id);

	public List<DeliveryStaffEntity> findDeliveryStaff(
			String deliveryStaffName, Integer id);

	public List<DeliveryStaffEntity> findBySubstation(Integer id);

}
