package com.iqmsoft.boot.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.test.demo.entity.Location;
import com.iqmsoft.boot.test.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationRepository locationRepository;

	@Override
	@Transactional
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location find(Long id) {
		return locationRepository.find(id);
	}
}
