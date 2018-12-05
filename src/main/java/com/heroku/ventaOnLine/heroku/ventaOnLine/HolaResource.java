package com.heroku.ventaOnLine.heroku.ventaOnLine;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaResource {
	
	@RequestMapping(value = "/Hola")
	public String modificar() {

		
		return "Se ha modificado el empleado";

	}


}
