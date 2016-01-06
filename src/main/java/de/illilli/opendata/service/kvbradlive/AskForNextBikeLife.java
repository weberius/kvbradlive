package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AskForNextBikeLife {

	String url = "http://api.nextbike.net/maps/nextbike-live.xml?city=14";

	private static final Logger logger = Logger.getLogger(AskForNextBikeLife.class);

	private Markers markers;
	private InputStream inputStream;

	public AskForNextBikeLife() throws MalformedURLException, IOException {
		inputStream = new URL(url).openStream();
	}

	public AskForNextBikeLife(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Markers getMarkers() throws JsonParseException, JsonMappingException, IOException {
		XmlMapper mapper = new XmlMapper();
		markers = mapper.readValue(inputStream, Markers.class);
		logger.debug(markers.toString());
		return markers;
	}

}
