package com.zhidi.dao;

import java.util.List;

import com.zhidi.entity.Emp;
import com.zhidi.util.PagerHander;

public interface IEmpDao extends IBaseDao<Emp, Integer>{

	List<Emp> getEmpByPage(PagerHander hander);
	
	Integer getTotalRows();
}
