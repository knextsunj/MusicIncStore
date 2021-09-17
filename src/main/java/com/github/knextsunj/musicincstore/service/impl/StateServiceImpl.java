package com.github.knextsunj.musicincstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.knextsunj.musicincstore.dao.StateDAO;
import com.github.knextsunj.musicincstore.domain.Country;
import com.github.knextsunj.musicincstore.domain.State;
import com.github.knextsunj.musicincstore.dto.StateDTO;
import com.github.knextsunj.musicincstore.dto.mapper.StateMapper;
import com.github.knextsunj.musicincstore.service.CountryService;
import com.github.knextsunj.musicincstore.service.StateService;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDAO stateDAO;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateMapper stateMapper;

	@Override
	public boolean save(StateDTO stateDTO) {

		String countryName = stateDTO.getCountryDTO().getName();
		Country country = countryService.fetchCountrybyName(countryName);

		State state = new State();
		state.setCountry(country);
		state.setDescription(stateDTO.getName());

		State newState = stateDAO.save(state);

		return Objects.nonNull(newState) ? true : false;
	}

	@Override
	public StateDTO getState(Long id) {
		return stateMapper.stateToStateDTO(stateDAO.find(id));
	}

	@Override
	public StateDTO updateState(StateDTO stateDTO) {

		State updatedState = stateDAO.update(stateMapper.stateDTOToState(stateDTO));
		return stateMapper.stateToStateDTO(updatedState);
	}

	@Override
	public Long deleteState(Long id) {
		stateDAO.delete(id);
		return id;
	}

	@Override
	public State fetchStateByName(String name) {
		return stateDAO.findStateByDescription(name);
	}

	@Override
	public List<StateDTO> fetchAllStatesByCountry(Long countryId) {
		List<State> states = stateDAO.findAllStatesByCountryId(countryId);
		List<StateDTO> stateDTOList = new ArrayList<>();

		states.stream().forEach(state -> {
			stateDTOList.add(stateMapper.stateToStateDTO(state));
		});
		return stateDTOList;
	}

}
