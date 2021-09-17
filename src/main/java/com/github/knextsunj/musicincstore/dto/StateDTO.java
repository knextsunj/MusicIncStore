package com.github.knextsunj.musicincstore.dto;

import java.io.Serializable;
import java.util.Objects;

public class StateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2779062272390892593L;

	private CountryDTO countryDTO;

	private String name;

	private Long id;

	/**
	 * @return the countryDTO
	 */
	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	/**
	 * @param countryDTO the countryDTO to set
	 */
	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
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
		return Objects.hash(countryDTO, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StateDTO)) {
			return false;
		}
		StateDTO other = (StateDTO) obj;
		return Objects.equals(countryDTO, other.countryDTO) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "StateDTO [countryDTO=" + countryDTO + ", name=" + name + "]";
	}

}
