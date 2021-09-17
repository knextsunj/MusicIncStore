package com.github.knextsunj.musicincstore.dao;

public interface GenericDAO<T> {

	T save(T t);

	T find(Long id);

	T update(T t);
	
	void delete(Long id);

}
