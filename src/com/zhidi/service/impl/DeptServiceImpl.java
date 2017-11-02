package com.zhidi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.dao.IDeptDao;
import com.zhidi.entity.Dept;
import com.zhidi.service.IDeptService;
import com.zhidi.util.PagerHander;

@Service
public class DeptServiceImpl implements IDeptService{

	@Autowired
	private IDeptDao deptDao;
	
	@Override
	public void save(Dept dept) {
		deptDao.save(dept);
	}

	@Override
	public void delete(Integer id) {
		deptDao.delete(id);
	}

	@Override
	public void update(Dept dept) {
		deptDao.update(dept);
	}

	@Override
	public void saveOrUpdate(Dept dept) {
		deptDao.saveOrUpdate(dept);
	}

	@Override
	public Dept get(Integer id) {
		return deptDao.get(id);
	}

	@Override
	public List<Dept> getAll() {
		return deptDao.getAll();
	}

	@Override
	public List<Dept> getDeptByPage(PagerHander hander) {
		return deptDao.getDeptByPage(hander);
	}

	@Override
	public Integer getTotalRows() {
		return deptDao.getTotalRows();
	}

}
