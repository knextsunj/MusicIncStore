package com.github.knextsunj.musicincstore.service;

import java.util.List;

import com.github.knextsunj.musicincstore.domain.State;
import com.github.knextsunj.musicincstore.dto.StateDTO;

public interface StateService {

	boolean save(StateDTO stateDTO);

	StateDTO getState(Long id);

	StateDTO updateState(StateDTO stateDTO);

	Long deleteState(Long id);

	State fetchStateByName(String name);

	List<StateDTO> fetchAllStatesByCountry(Long countryId);
}
