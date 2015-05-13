package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.DeliveryStaffEntity;

public interface DeliveryStaffServiceIfac {
	
	/**
	 * 查询所有配送员
	 * @return list
	 */
	public List<DeliveryStaffEntity> findAll();
	
	/**
	 * 添加配送员
	 * @param deliveryStaff
	 * @return true
	 */
	public boolean saveDeliveryStaff(DeliveryStaffEntity deliveryStaff);

	/**
	 * 通过Id查找配送员
	 * @param id
	 * @return DeliveryStaffEntity
	 */
	public DeliveryStaffEntity findById(Integer id);

	/**
	 * 修改配送员信息
	 * @param deliveryStaff
	 * @return true
	 */
	public boolean update(DeliveryStaffEntity deliveryStaff);

	/**
	 * 删除配送员
	 * @param id
	 * @return true
	 */
	public boolean delect(Integer id);

	/**
	 * 条件查询配送员
	 * @param deliveryStaffName
	 * @param id
	 * @return list
	 */
	public List<DeliveryStaffEntity> findDeliveryStaff(
			String deliveryStaffName, Integer id);

	/**
	 * 通过分站查询配送员
	 * @param id
	 * @return list
	 */
	public List<DeliveryStaffEntity> findBySubstation(Integer id);

}
