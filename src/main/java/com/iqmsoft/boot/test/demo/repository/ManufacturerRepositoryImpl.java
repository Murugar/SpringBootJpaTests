package com.iqmsoft.boot.test.demo.repository;

import org.springframework.stereotype.Repository;

import com.iqmsoft.boot.test.demo.entity.Manufacturer;
import com.iqmsoft.boot.test.demo.projection.ManufacturerProjection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Repository
public class ManufacturerRepositoryImpl implements ManufacturerRepository{

  @PersistenceContext
  EntityManager em;

  @Override
  public Manufacturer save(Manufacturer manufacturer) {
    em.persist(manufacturer);
    em.flush();
    return manufacturer;
  }

  @Override
  public Manufacturer find(Long id) {
    return em.find(Manufacturer.class, id);
  }

  @Override
  public ManufacturerProjection findAndView(Long id) {
    Query jpql = em.createQuery("SELECT NEW com.t3.spring.boot.demo.projection.ManufacturerProjection(" +
                                "m.name, m.active, l.state, l.country) " +
                                "FROM Manufacturer m, Location l " +
                                "WHERE m.location.id = l.id and m.id = :id");
    jpql.setParameter("id", id);
    return (ManufacturerProjection) jpql.getSingleResult();
  }
}
