package de.illilli.opendata.service.kvbradlive;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
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
	int show_bike_types;
	int show_free_racks;
	int booked_bikes;
	int set_point_bikes;
	int available_bikes;

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

	@XmlAttribute
	public int getShow_bike_types() {
		return show_bike_types;
	}

	public void setShow_bike_types(int show_bike_types) {
		this.show_bike_types = show_bike_types;
	}

	@XmlAttribute
	public int getShow_free_racks() {
		return show_free_racks;
	}

	public void setShow_free_racks(int show_free_racks) {
		this.show_free_racks = show_free_racks;
	}

	@XmlAttribute
	public int getBooked_bikes() {
		return booked_bikes;
	}

	public void setBooked_bikes(int booked_bikes) {
		this.booked_bikes = booked_bikes;
	}

	@XmlAttribute
	public int getSet_point_bikes() {
		return set_point_bikes;
	}

	public void setSet_point_bikes(int set_point_bikes) {
		this.set_point_bikes = set_point_bikes;
	}

	@XmlAttribute
	public int getAvailable_bikes() {
		return available_bikes;
	}

	public void setAvailable_bikes(int available_bikes) {
		this.available_bikes = available_bikes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + available_bikes;
		result = prime * result + booked_bikes;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((country_name == null) ? 0 : country_name.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((hotline == null) ? 0 : hotline.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((policy == null) ? 0 : policy.hashCode());
		result = prime * result + set_point_bikes;
		result = prime * result + show_bike_types;
		result = prime * result + show_free_racks;
		result = prime * result + ((terms == null) ? 0 : terms.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		result = prime * result + zoom;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (available_bikes != other.available_bikes)
			return false;
		if (booked_bikes != other.booked_bikes)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (country_name == null) {
			if (other.country_name != null)
				return false;
		} else if (!country_name.equals(other.country_name))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (hotline == null) {
			if (other.hotline != null)
				return false;
		} else if (!hotline.equals(other.hotline))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (policy == null) {
			if (other.policy != null)
				return false;
		} else if (!policy.equals(other.policy))
			return false;
		if (set_point_bikes != other.set_point_bikes)
			return false;
		if (show_bike_types != other.show_bike_types)
			return false;
		if (show_free_racks != other.show_free_racks)
			return false;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		if (zoom != other.zoom)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [city=" + city + ", lat=" + lat + ", lng=" + lng + ", zoom=" + zoom + ", name=" + name
				+ ", hotline=" + hotline + ", domain=" + domain + ", country=" + country + ", country_name="
				+ country_name + ", terms=" + terms + ", website=" + website + ", policy=" + policy
				+ ", show_bike_types=" + show_bike_types + ", show_free_racks=" + show_free_racks + ", booked_bikes="
				+ booked_bikes + ", set_point_bikes=" + set_point_bikes + ", available_bikes=" + available_bikes + "]";
	}

}
