package br.com.chovebilu.reservatorio;

public class StatusReservatorio {
	private Reservatorio reservatorio;
	private Boolean statusChuva;
	private String imgChuva;
	private String txtChuva;
	
	public StatusReservatorio(){}
	
	public StatusReservatorio(Reservatorio res) {
		reservatorio = res;
		setStatusChuva(reservatorio.getPlu_dia());
		setChuva(statusChuva);
	}
	
	public Reservatorio getReservatorio(){
		return reservatorio;
	}	

	public Boolean getstatusChuva() {
		return statusChuva;
	}

	public void setStatusChuva(String acmDia) {
		if (Double.parseDouble(acmDia) != 0) {
			this.statusChuva = true;
		} else {
			this.statusChuva = false;
		}
		
	}

	public String getImgChuva() {
		return imgChuva;
	}

	public void setChuva(Boolean statusChuva) {
		if(getstatusChuva()){
			this.imgChuva = "img/tempo-02.png";
			this.txtChuva = "Tá Chovendo";
		}
		else{
			this.imgChuva = "img/tempo-01.png";
			this.txtChuva = "Tá Chovendo";
		}
		
	}

	public String getTxtChuva() {
		return txtChuva;
	}

}
