package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

public class AskForNextBikeLife implements AskFor<Markers> {

	String url = Config.getProperty("api.nextbike.net");

	private static final Logger logger = Logger.getLogger(AskForNextBikeLife.class);

	private Markers markers;
	private InputStream inputStream;

	public AskForNextBikeLife() throws MalformedURLException, IOException {
		inputStream = new URL(url).openStream();
		mapData();
	}

	public AskForNextBikeLife(InputStream inputStream) {
		this.inputStream = inputStream;
		mapData();
	}

	void mapData() {
		XmlMapper mapper = new XmlMapper();
		try {
			markers = mapper.readValue(inputStream, Markers.class);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	@Override
	public Markers getData() {
		logger.debug(markers.toString());
		return markers;
	}

}
