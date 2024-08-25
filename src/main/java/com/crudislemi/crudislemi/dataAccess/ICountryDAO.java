package com.crudislemi.crudislemi.dataAccess;
import com.crudislemi.crudislemi.entities.Country;

import java.util.List;

public interface ICountryDAO {

    void add(Country country);

    Country getById(int id);
    void deleteById(int id);
    void updateCountry(Country country);
    List<Country> getAll();
}
