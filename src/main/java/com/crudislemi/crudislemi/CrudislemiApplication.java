package com.crudislemi.crudislemi;

import com.crudislemi.crudislemi.dataAccess.ICountryDAO;
import com.crudislemi.crudislemi.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudislemiApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudislemiApplication.class, args);
	}

	@Bean
	@Autowired
	CommandLineRunner commandLineRunner(ICountryDAO countryDAO){
		return runner -> {
			//addCountry(countryDAO);
			//getCountryById(countryDAO);
			//deleteActorById(countryDAO);
			//updateCountry(countryDAO);
			getAllCountries(countryDAO);
		};

	}

	private void getAllCountries(ICountryDAO countryDAO) {
		List<Country> countries = countryDAO.getAll();

		for(Country country : countries){
			System.out.println(country);
		}
	}

	private void updateCountry(ICountryDAO countryDAO) {
		Country country = countryDAO.getById(105);
		System.out.println(country);

		country.setCountry("Türkiye");
		countryDAO.updateCountry(country);
		System.out.println(country);
	}

	private void deleteActorById(ICountryDAO countryDAO) {
		int id = 105;
		countryDAO.deleteById(id);
		Country country = countryDAO.getById(id);

		if(country == null){
			System.out.println("Ülke silindi....");
		}
		else{
			System.out.println("Ülke silinirken hata oluştu....");
		}
	}

	private void getCountryById(ICountryDAO countryDAO) {
		int id = 105;
		Country country = countryDAO.getById(id);

		if(country == null){
			System.out.println("Ülke bulunamadı....");
		}
		else{
			System.out.println(country);
		}
	}

	private void addCountry(ICountryDAO countryDAO) {
		Country country = new Country("example","07-02-2003");
		countryDAO.add(country);
		System.out.println(country);
	}

}
