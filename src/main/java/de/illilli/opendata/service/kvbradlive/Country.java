package de.illilli.opendata.service.kvbradlive;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

/**
 * <pre>
 * &lt;country 
 *   lat="50.9364" 
 *   lng="6.96053" 
 *   zoom="11" 
 *   name="KVB Rad Germany"
 *   hotline="+493069205046" 
 *   domain="kg" 
 *   country="DE" 
 *   country_name="Germany"
 *   terms="http://www.kvb-rad.de/de/agb/" website="http://www.kvb-rad.de/"
 *   website="http://www.kvb-rad.de/"&gt;
 * </pre>
 * 
 * @author wolfram
 *
 */
public class Country {

	List<City> city;
	double lat;
	double lng;
	int zoom;
	String name;
	String hotline;
	String domain;
	String country;
	String country_name;
	String terms;
	String website;
	String policy;

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	@XmlAttribute
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@XmlAttribute
	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	@XmlAttribute
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@XmlAttribute
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlAttribute
	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@XmlAttribute
	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	@XmlAttribute
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@XmlAttribute
	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

}
