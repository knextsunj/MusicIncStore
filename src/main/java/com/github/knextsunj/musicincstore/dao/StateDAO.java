package com.github.knextsunj.musicincstore.dao;

import java.util.List;

import com.github.knextsunj.musicincstore.domain.State;

public interface StateDAO extends GenericDAO<State> {

	State findStateByDescription(String description);

	List<State> findAllStatesByCountryId(Long countryId);

}
