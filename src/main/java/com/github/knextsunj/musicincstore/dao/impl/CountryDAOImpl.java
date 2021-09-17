package com.github.knextsunj.musicincstore.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.github.knextsunj.musicincstore.dao.CountryDAO;
import com.github.knextsunj.musicincstore.dao.base.GenericDAOImpl;
import com.github.knextsunj.musicincstore.domain.Country;

@Repository
public class CountryDAOImpl extends GenericDAOImpl<Country> implements CountryDAO {

	@Override
	public List<Country> findAll() {
		TypedQuery<Country> typedQuery = this.entityManager.createNamedQuery("Country.findAllCountries", Country.class);

		return typedQuery.getResultList();

	}

	@Override
	public Country findCountryByDescription(String description) {
		TypedQuery<Country> typedQuery = this.entityManager.createNamedQuery("Country.findCountryByDescription",
				Country.class);
		typedQuery.setParameter("name", description);
		return typedQuery.getSingleResult();
	}

}
