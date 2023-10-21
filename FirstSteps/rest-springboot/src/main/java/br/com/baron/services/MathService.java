package br.com.baron.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {
	
	public Double sum(String x, String y) {
		return Double.valueOf(x) + Double.valueOf(y);
	}
	
	public Double sub(String x, String y) {
		return Double.valueOf(x) - Double.valueOf(y);
	}
	
	public Double multiply(String x, String y) {
		return Double.valueOf(x) * Double.valueOf(y);
	}
	
	public Double div(String x, String y) {
		return Double.valueOf(x) / Double.valueOf(y);
	}
	
	public Double avg(String x, String y) {
		return (Double.valueOf(x) + Double.valueOf(y)) / 2;
	}
	
	public Double sqrt(String x) {
		return Math.sqrt(Double.valueOf(x));
	}
}
