package com.iqmsoft.boot.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.boot.test.demo.entity.Location;
import com.iqmsoft.boot.test.demo.entity.Manufacturer;
import com.iqmsoft.boot.test.demo.projection.ManufacturerProjection;
import com.iqmsoft.boot.test.demo.service.ManufacturerService;

@RestController
@RequestMapping("services/")
public class ManufacturerController {
	@Autowired
	ManufacturerService manufacturerService;

	@RequestMapping(value = "manufacturer/{id}", method = RequestMethod.GET)
	public Manufacturer find(@PathVariable Long id) {
		return manufacturerService.find(id);
	}

	@RequestMapping(value = "manufacturer/{id}/view", method = RequestMethod.GET)
	public ManufacturerProjection findAndView(@PathVariable Long id) {
		return manufacturerService.findAndView(id);
	}

	@RequestMapping(value = "manufacturer/{id}/location", method = RequestMethod.GET)
	public Location getLocation(@PathVariable Long id) {
		if (manufacturerService.find(id) != null) {
			return manufacturerService.find(id).getLocation();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "manufacturer", method = RequestMethod.POST)
	public Manufacturer save(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.save(manufacturer);
	}
}
