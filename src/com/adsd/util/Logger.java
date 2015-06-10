package com.adsd.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;

public class Logger {
	private static Boolean DEBUG = false;

	private static final String format = "HH:mm:ss";
	private final static String fileName = "dados-"+System.currentTimeMillis() ;
	private static File mfile;
	public static void log(String  ... params ){
		String line = "";
		for (final String param : params) {
			line += param + "\t";
        }
		line += "AT: "+ Instant.now().toString(DateTimeFormat.forPattern(format))+"\n";
		if(DEBUG)
			System.out.print(line);
		writeToFile(line);
	}
	
	private static void writeToFile(String data){
		mfile = new File(fileName);
		OutputStream out;
		try {
			out = new FileOutputStream(mfile, true);
			out.write(data.getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
