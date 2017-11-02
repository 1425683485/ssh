package com.zhidi.dao;

import java.util.List;

import com.zhidi.entity.Dept;
import com.zhidi.util.PagerHander;

public interface IDeptDao extends IBaseDao<Dept, Integer>{

	List<Dept> getDeptByPage(PagerHander hander);
	
	Integer getTotalRows();
}
