package br.com.chovebilu.scanner;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TrackerSabesp {
	List<String> reservatorios;
	private String vol_armazenado;
	private String plu_dia;
	private String plu_mes;
	private String plu_mediaMes;
	private static UrlSabesp url = new UrlSabesp(
			"http://sabesp-api.herokuapp.com");

	public TrackerSabesp() {
		reservatorios = new ArrayList<String>();
		JSONArray arraySabesp;
		JSONParser parser = new JSONParser();

		try {
			arraySabesp = (JSONArray) parser.parse(url.getBuffer().toString());

			for (int i = 0; i < arraySabesp.toArray().length; i++) {

				new JSONValue();
				JSONObject dados = (JSONObject) JSONValue.parse(arraySabesp
						.get(i).toString());
				new JSONValue();
				JSONArray array_dados = (JSONArray) JSONValue.parse(dados.get(
						"data").toString());

				reservatorios.add(dados.get("name").toString());
				System.out.println((i + 1) + "º RESERVATÓRIO: "
						+ reservatorios.get(i));

				for (int j = 0; j < array_dados.toArray().length; j++) {
					System.out.println(+(j + 1) + "nd DADO ======");
					System.out.println(array_dados.get(j));
					System.out.println();
				}

				System.out
						.println("#####################################################################");
			}

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "Parse Exception");
		}
	}

	public ArrayList<String> getReservatorios() {
		return (ArrayList<String>) reservatorios;
	}

	public String printReservatorios() {
		for (String string : reservatorios) {
			System.out.println(string);
		}
		return "Teste";
	}
}
