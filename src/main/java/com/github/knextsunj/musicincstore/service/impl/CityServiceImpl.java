package com.github.knextsunj.musicincstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.github.knextsunj.musicincstore.dao.CityDAO;
import com.github.knextsunj.musicincstore.domain.City;
import com.github.knextsunj.musicincstore.dto.CityDTO;
import com.github.knextsunj.musicincstore.dto.mapper.CityMapper;
import com.github.knextsunj.musicincstore.service.CityService;
import com.github.knextsunj.musicincstore.service.StateService;

@Stateless
@Local(CityService.class)
@LocalBean
public class CityServiceImpl implements CityService {

	@EJB
	private CityDAO cityDAO;

	@Inject
	private CityMapper cityMapper;

	@EJB
	private StateService stateService;

	@Override
	public boolean save(CityDTO cityDTO) {

		String stateName = cityDTO.getStateDTO().getStateName();

		City city = new City();
		city.setState(stateService.fetchStateByName(stateName));
		city.setDescription(cityDTO.getCityName());

		City savedCity = cityDAO.save(city);

		return Objects.nonNull(savedCity) ? true : false;
	}

	@Override
	public CityDTO getCity(Long id) {
		return cityMapper.cityToCityDTO(cityDAO.find(id));
	}

	@Override
	public CityDTO updateCity(CityDTO cityDTO) {
		City updatedCity = cityDAO.update(cityMapper.cityDTOToCity(cityDTO));
		return cityMapper.cityToCityDTO(updatedCity);
	}

	@Override
	public Long deleteCity(Long id) {
		cityDAO.delete(id);
		return id;
	}

	@Override
	public List<CityDTO> fetchAllCitiesByState(Long stateId) {
		List<City> cities = cityDAO.findAllCitiesByStateId(stateId);
		List<CityDTO> cityDTOList = new ArrayList<>();
		cities.stream().forEach(city -> {
			cityDTOList.add(cityMapper.cityToCityDTO(city));
		});
		return cityDTOList;
	}

}
