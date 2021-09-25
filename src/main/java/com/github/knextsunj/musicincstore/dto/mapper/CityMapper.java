package com.github.knextsunj.musicincstore.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.knextsunj.musicincstore.domain.City;
import com.github.knextsunj.musicincstore.dto.CityDTO;

@Mapper(componentModel = "spring")
public interface CityMapper {

	@Mapping(source = "cityName", target = "description")
	@Mapping(source = "stateDTO.stateName", target = "state.description")
	@Mapping(source = "stateDTO.id", target = "state.id")
	@Mapping(source="stateDTO.countryDTO.id", target = "state.country.id")
	@Mapping(source = "stateDTO.countryDTO.countryName", target = "state.country.description")
	City cityDTOToCity(CityDTO cityDTO);

	@Mapping(source = "description", target = "cityName")
	@Mapping(source = "state.description", target = "stateDTO.stateName")
	@Mapping(source = "state.id", target = "stateDTO.id")
	@Mapping(source="state.country.id", target = "stateDTO.countryDTO.id")
	@Mapping(source="state.country.description", target = "stateDTO.countryDTO.countryName")
	CityDTO cityToCityDTO(City city);
}
