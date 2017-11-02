package com.zhidi.service;

import java.util.List;

import com.zhidi.entity.Emp;
import com.zhidi.util.PagerHander;

public interface IEmpService {

	/**
	 * 保存
	 * @param dept
	 */
	void save(Emp dept);
	
	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	void delete(Integer id);
	
	/**
	 * 修改
	 * @param dept
	 */
	void update(Emp dept);
	
	/**
	 * 保存或修改
	 * @param dept
	 */
	void saveOrUpdate(Emp dept);
	
	/**
	 * 根据主键查询
	 * @param id 主键
	 * @return
	 */
	Emp get(Integer id);
	
	/**
	 * 获取所有数据
	 * @return
	 */
	List<Emp> getAll();
	
	/**
	 * 分页查询
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示的数目
	 * @return
	 */
	List<Emp> getDeptByPage(PagerHander hander);
	
	Integer getTotalRows();
}
