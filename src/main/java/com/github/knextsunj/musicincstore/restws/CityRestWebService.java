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

import com.github.knextsunj.musicincstore.dto.CityDTO;
import com.github.knextsunj.musicincstore.service.CityService;

@Controller
@RequestMapping("/city")
public class CityRestWebService {

	@Autowired
	private CityService cityService;

	@PostMapping("/save")
	@ResponseBody
	public boolean save(@RequestBody CityDTO cityDTO) {
		return cityService.save(cityDTO);
	}

	@GetMapping("/fetch/{id}")
	@ResponseBody
	public CityDTO getCity(@PathVariable("id") Long id) {
		return cityService.getCity(id);
	}

	@PutMapping("/update")
	@ResponseBody
	public CityDTO updateCity(@RequestBody CityDTO cityDTO) {
		return cityService.updateCity(cityDTO);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public Long deleteCity(@PathVariable("id") Long id) {
		return cityService.deleteCity(id);
	}

	@GetMapping("/findAllByState/{stateId}")
	@ResponseBody
	public List<CityDTO> findAllCitiesByState(@PathVariable("stateId") Long stateId) {
		return cityService.fetchAllCitiesByState(stateId);
	}
}
