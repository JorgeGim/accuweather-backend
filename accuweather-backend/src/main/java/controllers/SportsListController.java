package controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.DayFrontEnd;
import model.SportFrontEnd;
import services.ParametersValidatorService;
import services.SportService;
import services.SportsListService;

@RestController
public class SportsListController 
{	
	@Autowired
	private SportsListService sportsListService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	ParametersValidatorService parametersValidator;
	
	@RequestMapping(value = "/sports")
	public List<SportFrontEnd> createAndReturnSportList()
	{
		return sportsListService.generateAndReturnSportsList();
	}
	
	@RequestMapping(value = "/days")
	public List<DayFrontEnd> getDays(@RequestParam(value="name") String name, @RequestParam("numberOfDays") int numberOfDays) throws IOException
	{
		parametersValidator.validate(name, numberOfDays);
		return sportService.getAvailableDaysToPractice(name, numberOfDays);
	}
}
