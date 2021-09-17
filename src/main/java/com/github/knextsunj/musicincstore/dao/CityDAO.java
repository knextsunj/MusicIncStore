package com.github.knextsunj.musicincstore.dao;

import java.util.List;

import com.github.knextsunj.musicincstore.domain.City;

public interface CityDAO extends GenericDAO<City> {

	List<City> findAllCitiesByStateId(Long stateId);
}
