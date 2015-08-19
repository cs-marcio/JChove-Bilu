package br.com.chovebilu.control;

/**
 * @author cs-marcio
 * 
 * O contrutor da classe cria um ArrayList com todos os reservatórios obtidos do arquivo arraySabesp
 * 
 * */

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.chovebilu.model.Reservatorio;

public class Reservatorios {
	
	ArrayList<Reservatorio> reservatorios = new ArrayList<>();

	private JSONSabesp url = new JSONSabesp();

	public Reservatorios() {
		JSONArray arraySabesp;
		JSONParser parser = new JSONParser();

		try {
			arraySabesp = (JSONArray) parser.parse(url.getBuffer().toString());

			for (int i = 0; i < arraySabesp.toArray().length; i++) {
				Reservatorio r = new Reservatorio();

				new JSONValue();
				JSONObject dados = (JSONObject) JSONValue.parse(arraySabesp
						.get(i).toString());
				new JSONValue();
				JSONArray array_dados = (JSONArray) JSONValue.parse(dados.get(
						"data").toString());

				r.setName(dados.get("name").toString());
				
				for (int j = 0; j < array_dados.toArray().length; j++) {

					dados = (JSONObject) JSONValue.parse(array_dados.get(j)
							.toString());

					if (dados.get("key").toString().equals("volume armazenado")) {
						if (dados.get("value").toString().contains("n")) {
							r.setVol_armazenado(getVolumeArmazenado(dados.get("value").toString()));							
						} else {
							r.setVol_armazenado(onlyNumbersAndDot(dados.get("value").toString()));
						}
						
					} else if (dados.get("key").toString()
							.equals("pluviometria do dia")) {
						r.setPlu_dia(onlyNumbersAndDot(dados.get("value")
								.toString()));
					} else if (dados.get("key").toString()
							.equals("pluviometria acumulada no mês")) {
						r.setPlu_mes(onlyNumbersAndDot(dados.get("value")
								.toString()));
					} else if (dados.get("key").toString()
							.equals("média histórica do mês")) {
						r.setPlu_mediaMes(onlyNumbersAndDot(dados.get("value")
								.toString()));
					}
				}
				reservatorios.add(r);
			}

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "Parse Exception");
		}
	}

	public void setReservatorio(String Reservatorio) {

	}

	public ArrayList<Reservatorio> getReservatorios() {
		return reservatorios;
	}

	public Reservatorio getReservatorio(String nome_reservatorio) {
		try {
			for (Reservatorio reservatorio : reservatorios) {
				if (reservatorio.getName().equals(nome_reservatorio)) {
					return reservatorio;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String onlyNumbersAndDot(String str) {
		if (str != null) {
			return str.replaceAll("[^0123456789,]", "").replace(",", ".");
		} else {
			return "";
		}
	}
	
	public String getVolumeArmazenado(String volArmaz){
		String indice1, indice2, indice3;
		Double indice;
		
		indice1 = volArmaz.substring(volArmaz.indexOf("1:") + 3, volArmaz.indexOf("1:") + 8);
		indice2 = volArmaz.substring(volArmaz.indexOf("2:") + 3, volArmaz.indexOf("2:") + 8);
		indice3 = volArmaz.substring(volArmaz.indexOf("3:") + 3, volArmaz.indexOf("3:") + 8);
		
		indice = (Double.parseDouble(indice1.replace(",", ".")))
					+(Double.parseDouble(indice2.replace(",", ".")))
					+(Double.parseDouble(indice3.replace(",", ".")));
		
		return indice.toString();
	}
}
