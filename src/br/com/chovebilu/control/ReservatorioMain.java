package br.com.chovebilu.control;

/**
 * @author cs-marcio
 * 
 * Realiza as operações necessárias com o objeto Reservatorio
 * 
 * */
import br.com.chovebilu.model.Reservatorio;

public class ReservatorioMain {
	private Reservatorio reservatorio;
	private int nivelChuva;
	private String imgNivelChuva;
	private double nivelReservatorio;
	private String imgNivelReservatorio;

	public void setReservatorio(String reservatorio) {
		this.reservatorio = new Reservatorios().getReservatorio(reservatorio);
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
	}
	
	/** @return Reservatorio - Retorna o objeto Reservatório*/
	public Reservatorio getReservatorio() {
		return this.reservatorio;
	}

	/** @return int - Retorna o nível da chuva de 1 a 5*/
	public int getNivelChuva() {
		return nivelChuva;
	}

	/** @return String - Retorna o caminho da imagem do Nível de Chuva com base no nível de chuva*/
	public String getImgNivelChuva() {
		return imgNivelChuva;
	}

	/** @return double - Retorna o nível do reservatório*/
	public String getNivelReservatorio() {
		return String.format("%.2f", nivelReservatorio);
	}

	/** @return String - Retorna o caminho da imagem do Nível do Reservatorio com base no nível de chuva*/
	public String getImgNivelReservatorio() {
		return imgNivelReservatorio;
	}
}
