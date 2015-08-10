package br.com.chovebilu.scanner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.chovebilu.reservatorio.Reservatorio;

public class TrackerSabesp {
	ArrayList<Reservatorio> reservatorios = new ArrayList<>();

	private static UrlSabesp url = new UrlSabesp(
			"https://sabesp-api.herokuapp.com");

	public TrackerSabesp() {
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
						r.setVol_armazenado(onlyNumbersAndDot(dados
								.get("value").toString()));
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
}
