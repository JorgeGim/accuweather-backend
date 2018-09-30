package controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.InfoClima;
import services.InfoClimaService;

@RestController
public class InfoClimaController 
{	
	@Autowired
	private InfoClimaService infoClimaService;
	
	@RequestMapping(value = "/info")
	public InfoClima getInfo() throws IOException  
	{	
		return infoClimaService.getInfo();
	}
}
