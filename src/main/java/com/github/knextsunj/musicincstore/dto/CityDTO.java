package com.github.knextsunj.musicincstore.dto;

import java.io.Serializable;
import java.util.Objects;

public class CityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5249267074077955829L;

	private StateDTO stateDTO;

	private String cityName;

	private Long id;

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

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
		return Objects.hash(cityName, stateDTO);
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
		return Objects.equals(cityName, other.cityName) && Objects.equals(stateDTO, other.stateDTO);
	}

	@Override
	public String toString() {
		return "CityDTO [stateDTO=" + stateDTO + ", name=" + cityName + "]";
	}

}
