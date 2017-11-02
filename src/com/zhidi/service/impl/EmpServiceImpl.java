package com.zhidi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.dao.IEmpDao;
import com.zhidi.entity.Emp;
import com.zhidi.service.IEmpService;
import com.zhidi.util.PagerHander;

@Service
public class EmpServiceImpl implements IEmpService{
	
	@Autowired
	private IEmpDao empDao;

	@Override
	public void save(Emp dept) {
		empDao.save(dept);
	}

	@Override
	public void delete(Integer id) {
		empDao.delete(id);
	}

	@Override
	public void update(Emp dept) {
		empDao.update(dept);
	}

	@Override
	public void saveOrUpdate(Emp dept) {
		empDao.saveOrUpdate(dept);
	}

	@Override
	public Emp get(Integer id) {
		return empDao.get(id);
	}

	@Override
	public List<Emp> getAll() {
		return empDao.getAll();
	}

	@Override
	public List<Emp> getDeptByPage(PagerHander hander) {
		
		return empDao.getEmpByPage(hander);
	}

	@Override
	public Integer getTotalRows() {
		return empDao.getTotalRows();
	}

}
