package br.com.chovebilu.model;

/**
 * @author cs-marcio
 * 
 * Cria o objeto Reservatorio.
 * 
 * */
public class Reservatorio {
	private String name;				// NOME DO RESERVATÓRIO
	private String vol_armazenado;		// VOLUME ARMAZENADO NO RESERVATÓRIO
	private String plu_dia;				// PLUVIOMETRIA DO DIA PARA O RESERVATÓRIO
	private String plu_mes;				// PLUVIOMETRIA DO MENSAL DO RESERVATÓRIO
	private String plu_mediaMes;		// MÉDIA PLUVIOMÉTRICA DO MÊS
	
	/** @return String - Nome do Reservatório*/
	public String getName() {
		return name;
	}
	public void setName(String reservatorio) {
		this.name = reservatorio;
	}
	
	/** @return String - Volume Armazenado do Reservatório*/
	public String getVol_armazenado() {
		return vol_armazenado;
	}
	public void setVol_armazenado(String vol_armazenado) {
		this.vol_armazenado = vol_armazenado;
	}
	
	/** @return String - Pluviometria Diária do Reservatório*/
	public String getPlu_dia() {
		return plu_dia;
	}
	public void setPlu_dia(String plu_dia) {
		this.plu_dia = plu_dia;
	}
	
	/** @return String - Pluviometria Mensal do Reservatório*/
	public String getPlu_mes() {
		return plu_mes;
	}
	public void setPlu_mes(String plu_mes) {
		this.plu_mes = plu_mes;
	}
	
	/** @return String - Média Pluviométrica do Reservatório*/
	public String getPlu_mediaMes() {
		return plu_mediaMes;
	}
	public void setPlu_mediaMes(String plu_mediaMes) {
		this.plu_mediaMes = plu_mediaMes;
	}
}
