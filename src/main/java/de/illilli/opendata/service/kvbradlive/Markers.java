package de.illilli.opendata.service.kvbradlive;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Markers {

	List<Country> country;

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

}
