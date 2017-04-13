package com.iqmsoft.boot.test.demo.repository;

import org.springframework.stereotype.Repository;

import com.iqmsoft.boot.test.demo.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
public class LocationRepositoryImpl implements LocationRepository {

  @PersistenceContext
  EntityManager em;

  @Override
  public Location save(Location location) {
    em.persist(location);
    em.flush();
    return location;
  }

  @Override
  public Location find(Long id) {
    return em.find(Location.class, id);
  }
}
