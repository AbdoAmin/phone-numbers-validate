package com.abdelrahman.amin.service;

import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Customer;

import java.util.List;

public interface CustomerService {
    PageResponse<List<Customer>> getCustomersByCountryRegex(String countryName, Integer pageNumber);

    PageResponse<List<Customer>>  getAllNotValidPhoneByCountry(String countryName, Integer pageNumber);

    PageResponse<List<Customer>>  getAllCountryPhones(String countryName, Integer pageNumber);

    PageResponse<List<Customer>> getAllPhoneNumbers(Integer pageNumber);
}
