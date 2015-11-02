package de.illilli.opendata.service.kvbradlive;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * <place 
 * 		uid="35409" 
 * 		lat="50.9429485" 
 * 		lng="6.958015" 
 * 		name="Hauptbahnhof"
 * 		spot="1"
 * 		number="4826" 
 * 		bikes="4" 
 * 		terminal_type="free"
 * 		bike_numbers="21640,21371,21336,21507" />
 * </pre>
 *
 */
@XmlRootElement(name = "place")
public class Place {

	int uid;
	double lat;
	double lng;
	String name;
	int spot;
	int number;

	/**
	 * All bikes listed; possible values:
	 * <ul>
	 * <li>0: no bike</li>
	 * <li>1: one bike</li>
	 * <li>2: two bikes</li>
	 * <li>3: three bikes</li>
	 * <li>4: four bikes</li>
	 * <li>5+: five or more bikes</li>
	 * </ul>
	 */
	String bikes;
	String terminal_type;
	String bike_numbers;
	int bike;
	String bike_racks;
	String maintenance;

	@XmlAttribute
	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	@XmlAttribute
	public String getBike_racks() {
		return bike_racks;
	}

	public void setBike_racks(String bike_racks) {
		this.bike_racks = bike_racks;
	}

	@XmlAttribute
	public int getBike() {
		return bike;
	}

	public void setBike(int bike) {
		this.bike = bike;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

	@XmlAttribute
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@XmlAttribute
	public String getBikes() {
		return bikes;
	}

	public void setBikes(String bikes) {
		this.bikes = bikes;
	}

	public String getTerminal_type() {
		return terminal_type;
	}

	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	@XmlAttribute
	public String getBike_numbers() {
		return bike_numbers;
	}

	public void setBike_numbers(String bike_numbers) {
		this.bike_numbers = bike_numbers;
	}

	@Override
	public String toString() {
		return "Place [uid=" + uid + ", lat=" + lat + ", lng=" + lng
				+ ", name=" + name + ", spot=" + spot + ", number=" + number
				+ ", bikes=" + bikes + ", terminal_type=" + terminal_type
				+ ", bike_numbers=" + bike_numbers + ", bike=" + bike
				+ ", bike_racks=" + bike_racks + ", maintenance=" + maintenance
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bike;
		result = prime * result
				+ ((bike_numbers == null) ? 0 : bike_numbers.hashCode());
		result = prime * result
				+ ((bike_racks == null) ? 0 : bike_racks.hashCode());
		result = prime * result + ((bikes == null) ? 0 : bikes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((maintenance == null) ? 0 : maintenance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + spot;
		result = prime * result
				+ ((terminal_type == null) ? 0 : terminal_type.hashCode());
		result = prime * result + uid;
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
		Place other = (Place) obj;
		if (bike != other.bike)
			return false;
		if (bike_numbers == null) {
			if (other.bike_numbers != null)
				return false;
		} else if (!bike_numbers.equals(other.bike_numbers))
			return false;
		if (bike_racks == null) {
			if (other.bike_racks != null)
				return false;
		} else if (!bike_racks.equals(other.bike_racks))
			return false;
		if (bikes == null) {
			if (other.bikes != null)
				return false;
		} else if (!bikes.equals(other.bikes))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (maintenance == null) {
			if (other.maintenance != null)
				return false;
		} else if (!maintenance.equals(other.maintenance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (spot != other.spot)
			return false;
		if (terminal_type == null) {
			if (other.terminal_type != null)
				return false;
		} else if (!terminal_type.equals(other.terminal_type))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

}
