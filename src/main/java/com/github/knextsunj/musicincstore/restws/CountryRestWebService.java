package com.github.knextsunj.musicincstore.restws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.knextsunj.musicincstore.dto.CountryDTO;
import com.github.knextsunj.musicincstore.service.CountryService;

@Stateless
@Path("/country")
public class CountryRestWebService {

	@EJB
	private CountryService countryService;

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveCountry(CountryDTO countryDTO) {
		return countryService.save(countryDTO);
	}

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<CountryDTO> getAllCountries() {
		return countryService.fetchAllcountries();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CountryDTO updateCountry(CountryDTO countryDTO) {
		return countryService.updateCountry(countryDTO);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Long deleteCountry(@PathParam("id") Long countryId) {
		return countryService.delete(countryId);
	}
}
