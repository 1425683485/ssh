package com.zhidi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhidi.dao.IEmpDao;
import com.zhidi.entity.Emp;
import com.zhidi.util.PagerHander;

@Repository
public class EmpDaoImpl extends BaseDaoImpl<Emp, Integer> implements IEmpDao{

	@Override
	public List<Emp> getEmpByPage(PagerHander hander) {
		
		
		return getSession().createQuery("from Emp ").setFirstResult((hander.getPageNum()-1)*hander.getPageSize()).setMaxResults(hander.getPageSize()).list();
	}

	@Override
	public Integer getTotalRows() {
		
		return (Integer) getSession().createQuery("select count(empno) from Emp").uniqueResult();
	}

}
