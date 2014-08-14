package com.jose;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 * @author jose alvarez muguerza
 * 
 */
public class Sender {
	private static final Logger LOG = Logger.getLogger(Sender.class);
	private final static String dash = " - ";
	private final static String message = " another log entry ";

	public static void main(String[] args) throws NumberFormatException,
			InterruptedException {

		InetAddress addr;
		String hostname = "No-IP";
		try {
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostAddress();

		} catch (UnknownHostException e) {
			// do nothing for now
		}
		if (args.length == 0) {
			System.out.println("Arguments:");
			System.out.println();
			System.out.println("  -i: Number of iterations");
			System.out
					.println("         example 1000 messages: 'java -jar log-msg-sender-1.0-SNAPSHOT-jar-with-dependencies.jar -i 1000'");
			System.out.println();
			System.out.println("  -f: Frequency");
			System.out
					.println("         example 100 messages every 30 seconds: 'java -jar log-msg-sender-1.0-SNAPSHOT-jar-with-dependencies.jar -f 100 30'");
			System.out.println();

		} else {

			if ("-i".equalsIgnoreCase(args[0].toString()) && (args.length == 2)) {
				for (int i = 0; i < Integer.parseInt(args[1]); i++) {
					LOG.info(i + dash + (int)(Math.random()*10)+1 + dash + message + dash
							+ hostname);

				}

				System.out.println("-i: interactions parameter received: "
						+ args[1] + " messages generated");

			} else if ("-f".equalsIgnoreCase(args[0].toString())
					&& (args.length == 3)) {
				System.out.println("-f: frequency parameter received: "
						+ args[1] + " messages generated every" + args[2]
						+ " second.");
				System.out.println("Ctrl-C for exit...");
				int counter = 0;
				while (true) {
					for (int i = 0; i < Integer.parseInt(args[1]); i++) {
						LOG.info(counter++ + dash + (int)(Math.random()*10)+1 + dash
								+ message + dash + hostname);
					}

					Thread.sleep(Integer.parseInt(args[2]) * 1000);

				}

			} else {
				System.out.println("Unsupported args");

			}

		}
	}
}
