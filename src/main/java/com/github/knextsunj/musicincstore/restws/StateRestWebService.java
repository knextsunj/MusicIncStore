package com.github.knextsunj.musicincstore.restws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.knextsunj.musicincstore.dto.StateDTO;
import com.github.knextsunj.musicincstore.service.StateService;

@Controller
@RequestMapping(value = "/state")
public class StateRestWebService {

	@Autowired
	private StateService stateService;

	@PostMapping(value = "/save")
	@ResponseBody
	public boolean saveState(@RequestBody StateDTO stateDTO) {
		return stateService.save(stateDTO);
	}

	@GetMapping(value = "/fetch/id")
	@ResponseBody
	public StateDTO fetchState(@PathVariable("id") Long id) {
		return stateService.getState(id);

	}

	@PutMapping(value = "/update")
	@ResponseBody
	public StateDTO updateState(@RequestBody StateDTO stateDTO) {
		return stateService.updateState(stateDTO);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public Long deleteState(@PathVariable("id") Long id) {
		return stateService.deleteState(id);
	}

	@GetMapping("/findAllByCountry/{countryId}")
	@ResponseBody
	public List<StateDTO> findAllStatesByCountry(@PathVariable("countryId") Long countryId) {
		return stateService.fetchAllStatesByCountry(countryId);
	}
}
