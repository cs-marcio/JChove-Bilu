package br.com.chovebilu.testeMain;

import java.util.ArrayList;

import br.com.chovebilu.control.Reservatorios;
import br.com.chovebilu.model.Reservatorio;

public class Test_main {

	public static void main(String[] args) {		
		Reservatorios sabesp = new Reservatorios();
		
		ArrayList<Reservatorio> reservatorios = sabesp.getReservatorios();
		
		for (Reservatorio r : reservatorios) {
			System.out.println(r.getVol_armazenado());
		}
	}

}
