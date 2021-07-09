package com.abdelrahman.amin.repository;

import com.abdelrahman.amin.entity.Country;
import com.abdelrahman.amin.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> getByName(String countryName);

}
