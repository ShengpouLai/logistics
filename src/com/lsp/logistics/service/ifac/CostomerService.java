package com.lsp.logistics.service.ifac;

import java.util.List;

import com.lsp.logistics.entity.CostomerEntity;

public interface CostomerService {
	
	/**
	 * 新客户基本信息录入
	 * @param costomer
	 * @return true
	 */
	public boolean saveCostomer(CostomerEntity costomer);
	
	/**
	 * 查询所有客户
	 * @return CostomerList
	 */
	public List<CostomerEntity> findAllCostomer();
	
	/**
	 * 通过Id删除客户
	 * @param costomerId
	 * @return true
	 */
	public boolean deleteCostomer(Integer costomerId);
	
	/**
	 * 通过Id查找客户
	 * @param costomerId
	 * @return Costomer
	 */
	public CostomerEntity findCostomerById(Integer costomerId);
	
	/**
	 * 修改客户信息
	 * @param costomer
	 * @return true
	 */
	public boolean updateCostomer(CostomerEntity costomer);
	
	/**
	 * 查询客户
	 * @param costomerId
	 * @param costomerName
	 * @param costomerMobailPhone
	 * @return CostomerList
	 */
	public List<CostomerEntity> findCostomer(String costomerId, String costomerName, String costomerMobailPhone);
}
