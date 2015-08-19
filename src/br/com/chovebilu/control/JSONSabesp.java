package br.com.chovebilu.control;

/**
 * @author cs-marcio
 * 
 * Realiza as operações necessárias com o objeto Reservatorio
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONSabesp {
	private String urlJSON;
	private StringBuffer buffer = null;

	JSONSabesp(){
		getUrlJSON();
		BufferedReader reader = null;
		try {
			URL url = new URL(urlJSON);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public String getBuffer() {
		return buffer.toString();
	}
	
	public void getUrlJSON(){
		String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());		
		urlJSON = "https://sabesp-api.herokuapp.com/"+dateNow;
	}
}
