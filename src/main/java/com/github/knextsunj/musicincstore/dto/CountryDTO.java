package com.github.knextsunj.musicincstore.dto;

import java.io.Serializable;
import java.util.Objects;

public class CountryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1446084164368883214L;

	private String countryName;

	private Long id;

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, countryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CountryDTO)) {
			return false;
		}
		CountryDTO other = (CountryDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(countryName, other.countryName);
	}

	@Override
	public String toString() {
		return "CountryDTO [name=" + countryName + ", id=" + id + "]";
	}

}
