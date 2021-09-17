package com.github.knextsunj.musicincstore.dto;

import java.io.Serializable;
import java.util.Objects;

public class CountryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1446084164368883214L;

	private String name;

	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "CountryDTO [name=" + name + ", id=" + id + "]";
	}

}
