package de.illilli.opendata.service.kvbradlive;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

/**
 * <pre>
 * &lt;city 
 *   uid="14" 
 *   lat="50.9429" 
 *   lng="6.95649" 
 *   zoom="12" 
 *   maps_icon="norisbike"
 *   alias="koeln" 
 *   break="0" 
 *   name="Köln"&gt;
 * </pre>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	List<Place> place;
	int uid;
	double lat;
	double lng;
	int zoom;
	String maps_icon;
	String alias;
	int _break;
	String name;
	int num_places;
	int refresh_rate;
	String bounds;
	int booked_bikes;
	int set_point_bikes;
	int available_bikes;

	@XmlAttribute
	public String getBounds() {
		return bounds;
	}

	public void setBounds(String bounds) {
		this.bounds = bounds;
	}

	@XmlAttribute
	public int getRefresh_rate() {
		return refresh_rate;
	}

	public void setRefresh_rate(int refresh_rate) {
		this.refresh_rate = refresh_rate;
	}

	@XmlAttribute
	public int getNum_places() {
		return num_places;
	}

	public void setNum_places(int num_places) {
		this.num_places = num_places;
	}

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}

	@XmlAttribute
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@XmlAttribute
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@XmlAttribute
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
	public String getMaps_icon() {
		return maps_icon;
	}

	public void setMaps_icon(String maps_icon) {
		this.maps_icon = maps_icon;
	}

	@XmlAttribute
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@XmlAttribute
	public int getBreak() {
		return _break;
	}

	public void setBreak(int bread) {
		this._break = bread;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		result = prime * result + _break;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + available_bikes;
		result = prime * result + booked_bikes;
		result = prime * result + ((bounds == null) ? 0 : bounds.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((maps_icon == null) ? 0 : maps_icon.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num_places;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + refresh_rate;
		result = prime * result + set_point_bikes;
		result = prime * result + uid;
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
		City other = (City) obj;
		if (_break != other._break)
			return false;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (available_bikes != other.available_bikes)
			return false;
		if (booked_bikes != other.booked_bikes)
			return false;
		if (bounds == null) {
			if (other.bounds != null)
				return false;
		} else if (!bounds.equals(other.bounds))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (maps_icon == null) {
			if (other.maps_icon != null)
				return false;
		} else if (!maps_icon.equals(other.maps_icon))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num_places != other.num_places)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (refresh_rate != other.refresh_rate)
			return false;
		if (set_point_bikes != other.set_point_bikes)
			return false;
		if (uid != other.uid)
			return false;
		if (zoom != other.zoom)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [place=" + place + ", uid=" + uid + ", lat=" + lat + ", lng=" + lng + ", zoom=" + zoom
				+ ", maps_icon=" + maps_icon + ", alias=" + alias + ", _break=" + _break + ", name=" + name
				+ ", num_places=" + num_places + ", refresh_rate=" + refresh_rate + ", bounds=" + bounds
				+ ", booked_bikes=" + booked_bikes + ", set_point_bikes=" + set_point_bikes + ", available_bikes="
				+ available_bikes + "]";
	}

}
