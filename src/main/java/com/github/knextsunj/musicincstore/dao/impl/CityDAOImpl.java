package com.github.knextsunj.musicincstore.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.github.knextsunj.musicincstore.dao.CityDAO;
import com.github.knextsunj.musicincstore.dao.base.GenericDAOImpl;
import com.github.knextsunj.musicincstore.domain.City;

@Stateless
@Local(CityDAO.class)
public class CityDAOImpl extends GenericDAOImpl<City> implements CityDAO {

	@Override
	public List<City> findAllCitiesByStateId(Long stateId) {
		TypedQuery<City> typedQuery = this.entityManager.createNamedQuery("City.findAllCitiesByStateId", City.class);
		typedQuery.setParameter("stateId", stateId);
		return typedQuery.getResultList();

	}

}
