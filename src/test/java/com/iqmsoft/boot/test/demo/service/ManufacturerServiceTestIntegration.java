package com.iqmsoft.boot.test.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.boot.test.demo.SpringBootJpaApplication;
import com.iqmsoft.boot.test.demo.entity.Location;
import com.iqmsoft.boot.test.demo.entity.Manufacturer;
import com.iqmsoft.boot.test.demo.service.LocationService;
import com.iqmsoft.boot.test.demo.service.ManufacturerService;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@PropertySource("classpath:application-test.properties")
public class ManufacturerServiceTestIntegration {
	@Autowired
	ManufacturerService manufacturerService;

	@Autowired
	LocationService locationService;

	@Test
	public void save() throws Exception {
		Manufacturer newManufacturer = new Manufacturer();
		newManufacturer.setActive(true);
		newManufacturer.setName("Trinh Toan Trung");
		newManufacturer.setFoundeddate(new Date());
		newManufacturer.setAverageyearlysales(new BigDecimal(12.24));

		Location location = locationService.find(1L);
		if (location != null) {
			newManufacturer.setLocation(location);
		}

		Manufacturer returnedManufacturerService = manufacturerService.save(newManufacturer);
		System.out.println(returnedManufacturerService.getId() + " - " + returnedManufacturerService.getActive() + " - "
				+ returnedManufacturerService.getFoundeddate() + " - "
				+ returnedManufacturerService.getAverageyearlysales() + " - " + returnedManufacturerService.getName()
				+ " - " + returnedManufacturerService.getLocation().getId());

		assertNotNull(returnedManufacturerService);
		assertNotNull(returnedManufacturerService.getId());
		assertNotNull(returnedManufacturerService.getName());
		assertNotNull(returnedManufacturerService.getFoundeddate());
		assertNotNull(returnedManufacturerService.getAverageyearlysales());
	}

}