package com.abdelrahman.amin.repository;

import com.abdelrahman.amin.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM CUSTOMER where phone regexp :reg",
            countQuery = "SELECT count(*) FROM CUSTOMER where phone regexp :reg",
            nativeQuery = true)
    Page<Customer> getAllByPhoneRegex(String reg, Pageable pageable);


    @Query(value = "SELECT * FROM CUSTOMER where phone like :countryCode and phone not regexp :reg",
            countQuery = "SELECT count(*) FROM CUSTOMER where phone like :countryCode and phone not regexp :reg",
            nativeQuery = true)
    Page<Customer> getAllNotValidPhoneByCountry(String countryCode, String reg, Pageable pageable);

    Page<Customer> getAllByPhoneLike(String countryCode, Pageable pageable);

}
