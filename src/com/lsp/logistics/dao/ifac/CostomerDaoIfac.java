package com.lsp.logistics.dao.ifac;

import java.util.List;

import com.lsp.logistics.entity.CostomerEntity;

public interface CostomerDaoIfac extends BaseDao<CostomerEntity> {
	
	public List<CostomerEntity> findCostomer(String costomerId, String costomerName, String costomerMobailPhone);

}
