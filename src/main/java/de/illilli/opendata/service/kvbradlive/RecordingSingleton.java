package de.illilli.opendata.service.kvbradlive;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class RecordingSingleton {

	private static RecordingSingleton facade;
	private static KvbRadThread thread;

	private RecordingSingleton() {
	}

	public static RecordingSingleton getInstance() {
		if (facade == null) {
			facade = new RecordingSingleton();
		}
		return facade;
	}

	public void start() {
		if (thread == null) {
			thread = new KvbRadThread();
			thread.run();
		} else {
			thread.run();
		}
	}

	public void stop() {
		if (thread != null) {
			thread.interrupt();
		}
	}

	/**
	 * <p>
	 * <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html">
	 * Class java.lang.Thread</a>
	 * </p>
	 * <p>
	 * <a href=
	 * "https://www.dpunkt.de/java/Programmieren_mit_Java/Multithreading/3.html"
	 * >Threads in Java - Programmieren mit Java</a>
	 * </p>
	 */
	private static class KvbRadThread extends Thread {

		private static final Logger logger = Logger
				.getLogger(KvbRadThread.class);
		private static long milliseconds = 30000;
		private static boolean letItRun = true;

		@Override
		public void run() {
			logger.info("wait for '" + milliseconds + "' milliseconds");
			letItRun = true;
			while (letItRun) {
				logger.info("inside while: " + this.getId() + ""
						+ this.getName());
				try {
					new InsertBikeFacade().insert();
				} catch (IOException | SQLException | NamingException e1) {
					e1.printStackTrace();
				}
				// logger.info("insert '" + numberOfBikes + "' bikes.");
				try {
					sleep(milliseconds);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void interrupt() {
			letItRun = false;
		}
	}
}
