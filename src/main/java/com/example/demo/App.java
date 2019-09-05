package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {
	
	private CarController list;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	public App() {
		super();
		list = new CarController();
	}
	
	@RequestMapping(value = "/list")
	public ResponseEntity<ArrayList<Car>> list() {
		return new ResponseEntity<ArrayList<Car>>(list.list(), HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{index}")
	public ResponseEntity<Car> get(@PathVariable int index) {
		return new ResponseEntity<Car>(list.get(index), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create")
	public ResponseEntity<Car> create() {
		return new ResponseEntity<Car>(list.create(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{index}")
	public ResponseEntity<Car> update(@PathVariable int index, @RequestBody Car car) {
		list.update(index, car);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{index}")
	public ResponseEntity<Car> delete(@PathVariable int index) {
		Car car = list.delete(index);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
}
