package br.com.chovebilu.test;

import java.util.ArrayList;

import br.com.chovebilu.reservatorio.Reservatorio;
import br.com.chovebilu.scanner.TrackerSabesp;

public class Test_main {

	public static void main(String[] args) {		
		TrackerSabesp sabesp = new TrackerSabesp();
		
		ArrayList<Reservatorio> reservatorios = sabesp.getReservatorios();
		
		for (Reservatorio r : reservatorios) {
			System.out.println(r.getVol_armazenado());
		}
	}

}
