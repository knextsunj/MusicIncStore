package com.github.knextsunj.musicincstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.github.knextsunj.musicincstore.dao.CountryDAO;
import com.github.knextsunj.musicincstore.domain.Country;
import com.github.knextsunj.musicincstore.dto.CountryDTO;
import com.github.knextsunj.musicincstore.dto.mapper.CountryMapper;
import com.github.knextsunj.musicincstore.service.CountryService;

@Stateless
@Local(CountryService.class)
@LocalBean
public class CountryServiceImpl implements CountryService {

	@EJB
	private CountryDAO countryDAO;

	@Inject
	private CountryMapper countryMapper;

	@Override
	public boolean save(CountryDTO countryDTO) {
		Country country = countryMapper.countryDTOToCountry(countryDTO);
		Country newCountry = countryDAO.save(country);
		return Objects.nonNull(newCountry) ? true : false;
	}

	@Override
	public List<CountryDTO> fetchAllcountries() {
		List<Country> countryList = countryDAO.findAll();
		List<CountryDTO> countryDTOList = new ArrayList<>();
		countryList.stream().forEach(country -> {
			countryDTOList.add(countryMapper.countryToCountryDTO(country));
		});
		return countryDTOList;
	}

	@Override
	public CountryDTO updateCountry(CountryDTO countryDTO) {

		Country updatedCountry = countryDAO.update(countryMapper.countryDTOToCountry(countryDTO));
		return countryMapper.countryToCountryDTO(updatedCountry);
	}

	@Override
	public Long delete(Long id) {
		countryDAO.delete(id);
		return id;
	}

	@Override
	public Country fetchCountrybyName(String name) {
		return countryDAO.findCountryByDescription(name);
	}

}
