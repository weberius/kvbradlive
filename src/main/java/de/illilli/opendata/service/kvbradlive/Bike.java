package de.illilli.opendata.service.kvbradlive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <pre>
 * <bike 
 *   number="21653" 
 *   bike_type="15" 
 *   active="1" 
 *   state="ok" 
 *   electric_lock="1"/>
 * </pre>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bike {

	int number;
	int bike_type;
	int active;
	String state;
	int electric_lock;

}
