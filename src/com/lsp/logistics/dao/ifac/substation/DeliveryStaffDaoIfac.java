package com.lsp.logistics.dao.ifac.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.DeliveryStaffEntity;

public interface DeliveryStaffDaoIfac extends BaseDao<DeliveryStaffEntity> {

	List<DeliveryStaffEntity> findDeliveryStaff(String deliveryStaffName,
			Integer id);

	List<DeliveryStaffEntity> findBySubstation(Integer id);

}
