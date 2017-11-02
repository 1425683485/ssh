package com.zhidi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhidi.dao.IDeptDao;
import com.zhidi.entity.Dept;
import com.zhidi.util.PagerHander;

@Repository
public class DeptDaoImpl extends BaseDaoImpl<Dept, Integer> implements IDeptDao{

	@Override
	public List<Dept> getDeptByPage(PagerHander hander) {
		Query query = getSession().createQuery("from Dept");
		query.setFirstResult((hander.getPageNum()-1)*hander.getPageSize());
		query.setMaxResults(hander.getPageSize());
		return query.list();
	}

	@Override
	public Integer getTotalRows() {
		return Integer.parseInt(getSession().createQuery("select count(deptno) from Dept").uniqueResult().toString());
	}

}
