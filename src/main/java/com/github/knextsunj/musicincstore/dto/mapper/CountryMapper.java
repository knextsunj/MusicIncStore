package com.github.knextsunj.musicincstore.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.knextsunj.musicincstore.domain.Country;
import com.github.knextsunj.musicincstore.dto.CountryDTO;

@Mapper(componentModel = "spring")
public interface CountryMapper {

	@Mapping(source = "description", target = "name")
	CountryDTO countryToCountryDTO(Country country);
	
	@Mapping(source = "name", target = "description")
	Country countryDTOToCountry(CountryDTO countryDTO);
}
