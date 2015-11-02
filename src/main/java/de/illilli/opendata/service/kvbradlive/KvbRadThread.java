package de.illilli.opendata.service.kvbradlive;

import org.apache.log4j.Logger;

/**
 * <p>
 * <a
 * href="http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html">Class
 * java.lang.Thread</a>
 * </p>
 * <p>
 * <a href=
 * "https://www.dpunkt.de/java/Programmieren_mit_Java/Multithreading/3.html"
 * >Threads in Java - Programmieren mit Java</a>
 * </p>
 */
public class KvbRadThread extends Thread {

	private static final Logger logger = Logger.getLogger(KvbRadThread.class);
	private static long milliseconds;
	private static boolean letItRun = true;
	private static KvbRadThread recordingThread;

	private KvbRadThread() {
	}

	public static KvbRadThread getInstance(long seconds) {
		milliseconds = seconds * 1000;
		letItRun = true;
		if (recordingThread == null) {
			recordingThread = new KvbRadThread();
		}
		return recordingThread;
	}

	@Override
	public void run() {
		logger.info("wait for '" + milliseconds + "' milliseconds");
		while (letItRun) {
			logger.info(recordingThread.getId() + ""
					+ recordingThread.getName());
			// int numberOfBikes = new InsertBikeFacade().insert();
			// logger.info("insert '" + numberOfBikes + "' bikes.");
			try {
				sleep(milliseconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startRecording() {
		recordingThread.interrupt();
		recordingThread.run();
	}

	public void stopRecording() {
		letItRun = false;
		recordingThread.interrupt();
	}

	public static void main(String[] args) {
		new KvbRadThread().run();
	}

}
