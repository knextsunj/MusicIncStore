package com.github.knextsunj.musicincstore.service;

import java.util.List;

import com.github.knextsunj.musicincstore.dto.CityDTO;

public interface CityService {

	boolean save(CityDTO cityDTO);

	CityDTO getCity(Long id);

	CityDTO updateCity(CityDTO cityDTO);

	Long deleteCity(Long id);

	List<CityDTO> fetchAllCitiesByState(Long stateId);
}
