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

import com.github.knextsunj.musicincstore.dto.CityDTO;
import com.github.knextsunj.musicincstore.service.CityService;

@Stateless
@Path("/city")
public class CityRestWebService {

	@EJB
	private CityService cityService;

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean save(CityDTO cityDTO) {
		return cityService.save(cityDTO);
	}

	@GET
	@Path("/fetch/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CityDTO getCity(@PathParam("id") Long id) {
		return cityService.getCity(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CityDTO updateCity(CityDTO cityDTO) {
		return cityService.updateCity(cityDTO);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Long deleteCity(@PathParam("id") Long id) {
		return cityService.deleteCity(id);
	}

	@GET
	@Path("/findAllByState/{stateId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<CityDTO> findAllCitiesByState(@PathParam("stateId") Long stateId) {
		return cityService.fetchAllCitiesByState(stateId);
	}
}
