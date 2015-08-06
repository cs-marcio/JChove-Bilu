package br.com.chovebilu.control;

import java.util.ArrayList;

import br.com.chovebilu.scanner.TrackerSabesp;

public class Test_main {

	public static void main(String[] args) {
		TrackerSabesp sabesp = new TrackerSabesp();
		
		ArrayList<String> reservatorios = sabesp.getReservatorios();
		for (String string : reservatorios) {
			System.out.println(string);
		}
	}

}
