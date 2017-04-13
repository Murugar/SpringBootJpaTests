package com.iqmsoft.boot.test.demo.service;

import com.iqmsoft.boot.test.demo.entity.Location;


public interface LocationService {
  Location save(Location location);
  Location find(Long id);
}
