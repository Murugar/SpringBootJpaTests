package com.iqmsoft.boot.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.boot.test.demo.entity.Location;
import com.iqmsoft.boot.test.demo.service.LocationService;

@RestController
@RequestMapping("services/")
public class LocationController {
	@Autowired
	LocationService locationService;

	@RequestMapping(value = "location/{id}", method = RequestMethod.GET)
	public Location find(@PathVariable Long id) {
		return locationService.find(id);
	}

	@RequestMapping(value = "location", method = RequestMethod.POST)
	public Location save(@RequestBody Location location) {
		return locationService.save(location);
	}
}
