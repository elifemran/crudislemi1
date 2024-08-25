package com.crudislemi.crudislemi.dataAccess;

import com.crudislemi.crudislemi.entities.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAO implements ICountryDAO {

    private EntityManager entityManager;

    @Autowired
    public CountryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void add(Country country) {
        entityManager.persist(country);
    }

    @Override
    public Country getById(int id) {
        return entityManager.find(Country.class, id);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Country country = entityManager.find(Country.class, id);
        entityManager.remove(country);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        entityManager.merge(country);
    }

    @Override
    public List<Country> getAll() {
        TypedQuery<Country> query = entityManager.createQuery("FROM Country ",Country.class);
        return query.getResultList();
    }
}
