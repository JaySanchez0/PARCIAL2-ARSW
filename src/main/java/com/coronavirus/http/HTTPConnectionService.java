package com.coronavirus.http;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class HTTPConnectionService {
	/**
	 * 
	 * @return devuelve un json con todos los paises impactados por la enfermedad
	 */
	public JSONObject getCountriesImpact() {
		try {
			HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
					.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
					.header("x-rapidapi-key", "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513")
					.asString();
			return new JSONObject(response.getBody()).getJSONObject("data");
		} catch (UnirestException e) {
			return null;
		}
	}
	
	public JSONObject getCountryImpact(String country) {
		HttpResponse<String> response;
		try {
			response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
					.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
					.header("x-rapidapi-key", "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513")
					.asString();
			return new JSONObject(response.getBody()).getJSONObject("data");
		} catch (UnirestException e) {
			return null;
		}
	}
}
