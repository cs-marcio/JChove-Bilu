package br.com.chovebilu.reservatorio;

import br.com.chovebilu.scanner.TrackerSabesp;

public class ReservatorioMain {
	private Reservatorio reservatorio;
	private int nivelChuva;
	private String imgNivelChuva;
	private double nivelReservatorio;
	private String imgNivelReservatorio;

	public void setReservatorio(String reservatorio) {
		this.reservatorio = new TrackerSabesp().getReservatorio(reservatorio);
		setNivelChuva();
		setNivelReservatorio();
	}

	public void setNivelChuva() {
		this.nivelChuva = (int) ((Double.parseDouble(reservatorio.getVol_armazenado()) / Double
				.parseDouble(reservatorio.getPlu_mediaMes())) / 0.2);
		if(nivelChuva > 5){
			nivelChuva = 5;		
		}
		imgNivelChuva = "img/bilu_emoticons-0"+this.nivelChuva+".png";
	}
	
	public void setNivelReservatorio(){
		nivelReservatorio = Double.parseDouble(reservatorio.getVol_armazenado());
		imgNivelReservatorio = "img/escala_emotion-0"+this.nivelChuva+".png";
		System.out.println(imgNivelChuva);
		System.out.println(imgNivelReservatorio);
	}
	
	public Reservatorio getReservatorio() {
		return this.reservatorio;
	}

	public int getNivelChuva() {
		return nivelChuva;
	}

	public String getImgNivelChuva() {
		return imgNivelChuva;
	}

	public double getNivelReservatorio() {
		return nivelReservatorio;
	}

	public String getImgNivelReservatorio() {
		return imgNivelReservatorio;
	}
}
