package com.iqmsoft.boot.test.demo.repository;

import com.iqmsoft.boot.test.demo.entity.Location;



public interface LocationRepository {
  Location save(Location location);
  Location find(Long id);
}
