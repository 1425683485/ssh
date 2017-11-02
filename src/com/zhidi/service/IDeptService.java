package com.zhidi.service;

import java.util.List;

import com.zhidi.entity.Dept;
import com.zhidi.util.PagerHander;

public interface IDeptService {

	/**
	 * 保存
	 * @param dept
	 */
	void save(Dept dept);
	
	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void delete(Integer id);
	
	/**
	 * 修改
	 * @param dept
	 */
	void update(Dept dept);
	
	/**
	 * 保存或修改
	 * @param dept
	 */
	void saveOrUpdate(Dept dept);
	
	/**
	 * 根据主键查询
	 * @param id 主键
	 * @return
	 */
	Dept get(Integer id);
	
	/**
	 * 获取所有数据
	 * @return
	 */
	List<Dept> getAll();
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<Dept> getDeptByPage(PagerHander hander);
	
	Integer getTotalRows();
}
