package com.coronavirus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.modelo.Country;
import com.coronavirus.services.CoronavirusStatusServices;

@RestController
@RequestMapping(value="/coronavirusapi")
public class CoronavirusStatusController {
	@Autowired
	private CoronavirusStatusServices services;
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public ResponseEntity<?> getCountries(){
		return new ResponseEntity<>(services.getCountries(),HttpStatus.ACCEPTED);
	}
	@RequestMapping(value="/country/{name}")
	public ResponseEntity<?> getCountry(@PathVariable String name){
		Country country = services.getCountry(name);
		if(country!=null) {
			return new ResponseEntity<>(services.getCountry(name),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
