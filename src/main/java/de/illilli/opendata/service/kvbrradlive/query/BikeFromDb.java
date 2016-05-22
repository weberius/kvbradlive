package de.illilli.opendata.service.kvbrradlive.query;

import java.sql.Timestamp;

/**
 * Klasse, die ein Bike repräsentiert. SQL bzw. Postgres-relevante Daten
 * möglich.
 */
public class BikeFromDb {

	int uid;
	String name;
	int bike;
	int number;
	Timestamp modtime;
	double lat;
	double lng;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBike() {
		return bike;
	}

	public void setBike(int bike) {
		this.bike = bike;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Timestamp getModtime() {
		return modtime;
	}

	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bike;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((modtime == null) ? 0 : modtime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
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
		BikeFromDb other = (BikeFromDb) obj;
		if (bike != other.bike)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (modtime == null) {
			if (other.modtime != null)
				return false;
		} else if (!modtime.equals(other.modtime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BikeFromDb [uid=" + uid + ", name=" + name + ", bike=" + bike + ", number=" + number + ", modtime="
				+ modtime + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
