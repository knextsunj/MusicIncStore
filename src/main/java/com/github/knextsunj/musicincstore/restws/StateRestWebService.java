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

import com.github.knextsunj.musicincstore.dto.StateDTO;
import com.github.knextsunj.musicincstore.service.StateService;

@Stateless
@Path("/state")
public class StateRestWebService {

	@EJB
	private StateService stateService;

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveState(StateDTO stateDTO) {
		return stateService.save(stateDTO);
	}

	@GET
	@Path("/fetch/id")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public StateDTO fetchState(@PathParam("id") Long id) {
		return stateService.getState(id);

	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public StateDTO updateState(StateDTO stateDTO) {
		return stateService.updateState(stateDTO);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Long deleteState(@PathParam("id") Long id) {
		return stateService.deleteState(id);
	}

	@GET
	@Path("/findAllByCountry/{countryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<StateDTO> findAllStatesByCountry(@PathParam("countryId") Long countryId) {
		return stateService.fetchAllStatesByCountry(countryId);
	}
}
