package br.com.chovebilu.reservatorio;

public class Reservatorio {
	private String name;
	private String vol_armazenado;
	private String plu_dia;
	private String plu_mes;
	private String plu_mediaMes;
	
	public String getName() {
		return name;
	}
	public void setName(String reservatorio) {
		this.name = reservatorio;
	}
	public String getVol_armazenado() {
		return vol_armazenado;
	}
	public void setVol_armazenado(String vol_armazenado) {
		this.vol_armazenado = vol_armazenado;
	}
	public String getPlu_dia() {
		return plu_dia;
	}
	public void setPlu_dia(String plu_dia) {
		this.plu_dia = plu_dia;
	}
	public String getPlu_mes() {
		return plu_mes;
	}
	public void setPlu_mes(String plu_mes) {
		this.plu_mes = plu_mes;
	}
	public String getPlu_mediaMes() {
		return plu_mediaMes;
	}
	public void setPlu_mediaMes(String plu_mediaMes) {
		this.plu_mediaMes = plu_mediaMes;
	}
}
