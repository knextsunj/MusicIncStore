package com.github.knextsunj.musicincstore.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.knextsunj.musicincstore.dao.GenericDAO;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T save(final T t) {

		entityManager.persist(t);
		return t;
	}

	@Override
	public T find(final Long id) {

		return entityManager.find(type, id);
	}

	@Override
	public T update(final T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(final Long id) {
		entityManager.remove(find(id));
	}
}
