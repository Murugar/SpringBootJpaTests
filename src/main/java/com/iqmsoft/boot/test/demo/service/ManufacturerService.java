package com.iqmsoft.boot.test.demo.service;

import com.iqmsoft.boot.test.demo.entity.Manufacturer;
import com.iqmsoft.boot.test.demo.projection.ManufacturerProjection;


public interface ManufacturerService {
  Manufacturer save(Manufacturer manufacturer);
  Manufacturer find(Long id);

  ManufacturerProjection findAndView(Long id);
}
