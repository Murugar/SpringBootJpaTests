
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
import com.iqmsoft.boot.test.demo.service.LocationService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@PropertySource("classpath:application-test.properties")
public class LocationServiceTestIntegrationTest {
	@Autowired
	LocationService locationService;

	@Test
	public void testSave() throws Exception {
		Location newLocation = new Location();
		newLocation.setState("HCM");
		newLocation.setCountry("Vietnam");

		Location returnedLocation = locationService.save(newLocation);
		System.out.println(
				returnedLocation.getId() + " - " + returnedLocation.getCountry() + " - " + returnedLocation.getState());

		assertNotNull(returnedLocation);
		assertNotNull(returnedLocation.getId());
		assertNotNull(returnedLocation.getCountry());
		assertNotNull(returnedLocation.getState());
	}

	@Test
	public void testFind() throws Exception {
		Location location = locationService.find(1L);
		System.out.println(location.getId() + " - " + location.getCountry() + " - " + location.getState());

		assertNotNull(location);
		assertNotNull(location.getId());

	}
}
