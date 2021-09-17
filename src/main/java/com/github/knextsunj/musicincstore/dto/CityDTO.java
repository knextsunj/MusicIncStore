package com.github.knextsunj.musicincstore.dto;

import java.io.Serializable;
import java.util.Objects;

public class CityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5249267074077955829L;

	private StateDTO stateDTO;

	private String name;

	private Long id;

	/**
	 * @return the stateDTO
	 */
	public StateDTO getStateDTO() {
		return stateDTO;
	}

	/**
	 * @param stateDTO the stateDTO to set
	 */
	public void setStateDTO(StateDTO stateDTO) {
		this.stateDTO = stateDTO;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, stateDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CityDTO)) {
			return false;
		}
		CityDTO other = (CityDTO) obj;
		return Objects.equals(name, other.name) && Objects.equals(stateDTO, other.stateDTO);
	}

	@Override
	public String toString() {
		return "CityDTO [stateDTO=" + stateDTO + ", name=" + name + "]";
	}

}
