package com.github.knextsunj.musicincstore.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.knextsunj.musicincstore.domain.State;
import com.github.knextsunj.musicincstore.dto.StateDTO;

@Mapper(componentModel = "spring")
public interface StateMapper {

	@Mapping(source = "description", target = "stateName")
	@Mapping(source = "country.description", target = "countryDTO.countryName")
	@Mapping(source = "country.id", target = "countryDTO.id")
	StateDTO stateToStateDTO(State state);

	@Mapping(source = "stateName", target = "description")
	@Mapping(source = "countryDTO.countryName", target = "country.description")
	@Mapping(source = "countryDTO.id", target = "country.id")
	State stateDTOToState(StateDTO stateDTO);

}
