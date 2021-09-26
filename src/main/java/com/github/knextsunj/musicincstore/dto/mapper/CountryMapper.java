package com.github.knextsunj.musicincstore.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.knextsunj.musicincstore.domain.Country;
import com.github.knextsunj.musicincstore.dto.CountryDTO;

@Mapper(componentModel = "cdi")
public interface CountryMapper {

	@Mapping(source = "description", target = "countryName")
	CountryDTO countryToCountryDTO(Country country);
	
	@Mapping(source = "countryName", target = "description")
	Country countryDTOToCountry(CountryDTO countryDTO);
}
