package com.iqmsoft.boot.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.test.demo.entity.Manufacturer;
import com.iqmsoft.boot.test.demo.projection.ManufacturerProjection;
import com.iqmsoft.boot.test.demo.repository.ManufacturerRepository;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	@Transactional
	public Manufacturer save(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public Manufacturer find(Long id) {
		return manufacturerRepository.find(id);
	}

	@Override
	public ManufacturerProjection findAndView(Long id) {
		return manufacturerRepository.findAndView(id);
	}
}
