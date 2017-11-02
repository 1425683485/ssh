package com.zhidi.dao;

import java.util.List;

public interface IBaseDao<T,PK> {

	/**
	 * 保存
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void delete(PK id);
	
	/**
	 * 修改
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 保存或修改
	 * @param t
	 */
	void saveOrUpdate(T t);
	
	/**
	 * 根据主键查询
	 * @param id 主键
	 * @return
	 */
	T get(PK id);
	
	/**
	 * 获取所有数据
	 * @return
	 */
	List<T> getAll();
}
