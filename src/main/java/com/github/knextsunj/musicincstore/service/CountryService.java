package com.github.knextsunj.musicincstore.service;

import java.util.List;

import com.github.knextsunj.musicincstore.domain.Country;
import com.github.knextsunj.musicincstore.dto.CountryDTO;

public interface CountryService {

	boolean save(CountryDTO countryDTO);

	List<CountryDTO> fetchAllcountries();

	CountryDTO updateCountry(CountryDTO countryDTO);

	Long delete(Long id);

	Country fetchCountrybyName(String name);
}
