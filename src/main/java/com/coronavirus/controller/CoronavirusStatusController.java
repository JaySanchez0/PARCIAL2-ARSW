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
	/**
	 * 
	 * @return todos los paises
	 */
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public ResponseEntity<?> getCountries(){
		return new ResponseEntity<>(services.getCountries(),HttpStatus.ACCEPTED);
	}
	/**
	 * 
	 * @param name - nombre del pais a buscar
	 * @return datos del pais solicitado
	 */
	@RequestMapping(value="/country/{name}")
	public ResponseEntity<?> getCountry(@PathVariable String name){
		Country country = services.getCountry(name);
		if(country!=null) {
			return new ResponseEntity<>(services.getCountry(name),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
