package com.lsp.logistics.service.impl;

import java.util.List;

import com.lsp.logistics.dao.ifac.CostomerDaoIfac;
import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.service.ifac.CostomerService;

public class CostomerServiceImpl implements CostomerService {
	
	private CostomerDaoIfac costomerDao;

	public void setCostomerDao(CostomerDaoIfac costomerDao) {
		this.costomerDao = costomerDao;
	}

	/**
	 * 用户注册
	 * @param costomer 用户基本信息
	 */
	@Override
	public boolean saveCostomer(CostomerEntity costomer) {
		return this.costomerDao.save(costomer);
	}

	/**
	 * 查出所有用户
	 */
	@Override
	public List<CostomerEntity> findAllCostomer() {
		List<CostomerEntity> list = this.costomerDao.findAll();
		return list;
	}

	/**
	 * 删除选中的用户
	 * 
	 * @author Administrator
	 * @param costomerId 用户编号
	 */
	@Override
	public boolean deleteCostomer(Integer costomerId) {
		return this.costomerDao.delete(costomerId);
	}

	/**
	 * 通过Id查找用户
	 * @param costomerId 用户编号
	 */
	@Override
	public CostomerEntity findCostomerById(Integer costomerId) {
		return this.costomerDao.findById(costomerId);
	}

	/**
	 * 修改用户信息
	 * @param costomer 需要修改信息的用户
	 */
	@Override
	public boolean updateCostomer(CostomerEntity costomer) {
		return this.costomerDao.update(costomer);
	}

	/**
	 * 通过条件查找用户
	 * 
	 * @param costomerId 用户身份证号
	 * @param costomerName 用户姓名
	 * @param costomerMobailPhone 用户手机号
	 */
	@Override
	public List<CostomerEntity> findCostomer(String costomerId,
			String costomerName, String costomerMobailPhone) {
		return this.costomerDao.findCostomer(costomerId, costomerName, costomerMobailPhone);
	}

}
