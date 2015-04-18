package com.lsp.logistics.service.ifac;

import java.util.List;

import com.lsp.logistics.entity.CostomerEntity;

public interface CostomerService {
	public boolean saveCostomer(CostomerEntity costomer);
	public List<CostomerEntity> findAllCostomer();
	public boolean deleteCostomer(Integer costomerId);
	public CostomerEntity findCostomerById(Integer costomerId);
	public boolean updateCostomer(CostomerEntity costomer);
	public List<CostomerEntity> findCostomer(String costomerId, String costomerName, String costomerMobailPhone);
}
