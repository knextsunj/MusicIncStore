package com.github.knextsunj.musicincstore.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.github.knextsunj.musicincstore.dao.StateDAO;
import com.github.knextsunj.musicincstore.dao.base.GenericDAOImpl;
import com.github.knextsunj.musicincstore.domain.State;

@Stateless
@Local(StateDAO.class)
public class StateDAOImpl extends GenericDAOImpl<State> implements StateDAO {

	@Override
	public State findStateByDescription(String description) {
		TypedQuery<State> typedQuery = this.entityManager.createNamedQuery("State.findStateByDescription", State.class);
		typedQuery.setParameter("name", description);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<State> findAllStatesByCountryId(Long countryId) {
		TypedQuery<State> typedQuery = this.entityManager.createNamedQuery("State.findAllStatesByCountryId",
				State.class);
		typedQuery.setParameter("countryId", countryId);
		return typedQuery.getResultList();
	}

}
