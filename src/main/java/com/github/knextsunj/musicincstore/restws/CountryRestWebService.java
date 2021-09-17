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

import com.github.knextsunj.musicincstore.dto.CountryDTO;
import com.github.knextsunj.musicincstore.service.CountryService;

@Controller
@RequestMapping(value = "/country")
public class CountryRestWebService {

	@Autowired
	private CountryService countryService;

	@PostMapping(value = "/save")
	@ResponseBody
	public boolean saveCountry(@RequestBody CountryDTO countryDTO) {
		return countryService.save(countryDTO);
	}

	@GetMapping(value = "/findAll")
	@ResponseBody
	public List<CountryDTO> getAllCountries() {
		return countryService.fetchAllcountries();
	}

	@PutMapping(value = "/update")
	@ResponseBody
	public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
		return countryService.updateCountry(countryDTO);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public Long deleteCountry(@PathVariable("id") Long countryId) {
		return countryService.delete(countryId);
	}
}
