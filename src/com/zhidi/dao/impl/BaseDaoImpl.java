package com.zhidi.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhidi.dao.IBaseDao;

@Repository
public class BaseDaoImpl<T,PK extends Serializable> implements IBaseDao<T, PK>{

	private Class entityClass;
	
	public BaseDaoImpl() {
		Class clz = getClass();
		Type type = clz.getGenericSuperclass();	
		if (type  instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			entityClass = (Class) types[0];
		}
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(PK id) {
		getSession().delete(get(id));
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}
	
	@Override
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public T get(PK id) {
		return (T) getSession().get(entityClass, id);
	}

	@Override
	public List<T> getAll() {
		return getSession().createQuery("from " + entityClass.getName()).list();
	}

}
