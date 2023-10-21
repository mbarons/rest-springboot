package br.com.baron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.baron.exceptions.UnsupportedMathOperationException;
import br.com.baron.services.MathService;

@RestController	
public class MathController {
	
	private final MathService mathService;
	
	public MathController(MathService mathService) {
		this.mathService = mathService;
	}

	@RequestMapping(value = "/sum/{x}/{y}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="x") String x,
			@PathVariable(value="y") String y
			) {
		
		try {
			return mathService.sum(x, y);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
	@RequestMapping(value = "/sub/{x}/{y}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value="x") String x,
			@PathVariable(value="y") String y
			) {
		
		try {
			return mathService.sub(x, y);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
	@RequestMapping(value = "/multiply/{x}/{y}", method=RequestMethod.GET)
	public Double multiply(
			@PathVariable(value="x") String x,
			@PathVariable(value="y") String y
			) {
		
		try {
			return mathService.multiply(x, y);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
	@RequestMapping(value = "/div/{x}/{y}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value="x") String x,
			@PathVariable(value="y") String y
			) {
		
		try {
			return mathService.div(x, y);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
	@RequestMapping(value = "/average/{x}/{y}", method=RequestMethod.GET)
	public Double average(
			@PathVariable(value="x") String x,
			@PathVariable(value="y") String y
			) {
		
		try {
			return mathService.avg(x, y);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
	@RequestMapping(value = "/sqrt/{x}", method=RequestMethod.GET)
	public Double sqrt(
			@PathVariable(value="x") String x
			) {
		
		try {
			return mathService.sqrt(x);
			} catch (Exception ex) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
	}
	
}

