package com.coronavirus.services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.cache.CoronavirusStatusCache;
import com.coronavirus.http.HTTPConnectionService;
import com.coronavirus.modelo.CountriesData;
import com.coronavirus.modelo.Province;

@Service
public class CoronavirusStatusServices {
	@Autowired
	private HTTPConnectionService http;
	@Autowired
	private CoronavirusStatusCache cache;
	public CountriesData getCountries() {
		CountriesData data = new CountriesData();
		JSONObject obj = http.getCountriesImpact();
		JSONArray arr = obj.getJSONArray("covid19Stats");
		for(int i=0;i<arr.length();i++) {
			JSONObject ob = arr.getJSONObject(i);
			data.addProvince(ob.getString("country"),new Province(ob.getString("province"),ob.getInt("deaths"),ob.getInt("confirmed"),ob.getInt("recovered")));
		}
		return data;
	}
}
