package com.github.knextsunj.musicincstore.dao;

import java.util.List;

import com.github.knextsunj.musicincstore.domain.Country;

public interface CountryDAO extends GenericDAO<Country> {

	List<Country> findAll();

	Country findCountryByDescription(String description);

}
