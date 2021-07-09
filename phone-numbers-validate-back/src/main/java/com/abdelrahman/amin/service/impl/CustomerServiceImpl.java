package com.abdelrahman.amin.service.impl;

import com.abdelrahman.amin.dto.PageResponse;
import com.abdelrahman.amin.entity.Country;
import com.abdelrahman.amin.entity.Customer;
import com.abdelrahman.amin.repository.CountryRepository;
import com.abdelrahman.amin.repository.CustomerRepository;
import com.abdelrahman.amin.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CountryRepository countryRepository;

    @Override
    public PageResponse<List<Customer>> getCustomersByCountryRegex(String countryName, Integer pageNumber) {
        Integer page = Optional.ofNullable(pageNumber).orElse(0);
        Country country = countryRepository.getByName(countryName).get();
        Page<Customer> customerPage = customerRepository.getAllByPhoneRegex(country.getPhoneRegex(), PageRequest.of(page, 10));

        return new PageResponse<>(
                customerPage.getContent(),page,customerPage.getTotalPages(),customerPage.getTotalElements());
    }
    @Override
    public PageResponse<List<Customer>>  getAllNotValidPhoneByCountry(String countryName, Integer pageNumber) {
        Integer page = Optional.ofNullable(pageNumber).orElse(0);
        Country country = countryRepository.getByName(countryName).get();
        String regexWithoutEscape = country.getPhoneRegex().replace("\\", "");
        String countryCode = regexWithoutEscape.substring(0, regexWithoutEscape.lastIndexOf(")")+1)  + "%";
        Page<Customer> customerPage = customerRepository.getAllNotValidPhoneByCountry(countryCode,country.getPhoneRegex(),PageRequest.of(page, 10));

        return new PageResponse<>(
                customerPage.getContent(),page,customerPage.getTotalPages(),customerPage.getTotalElements());
    }
    @Override
    public PageResponse<List<Customer>>  getAllCountryPhones(String countryName, Integer pageNumber) {
        Integer page = Optional.ofNullable(pageNumber).orElse(0);
        Country country = countryRepository.getByName(countryName).get();
        String regexWithoutEscape = country.getPhoneRegex().replace("\\", "");
        String countryCode = regexWithoutEscape.substring(0, regexWithoutEscape.lastIndexOf(")")+1)  + "%";
        Page<Customer> customerPage = customerRepository.getAllByPhoneLike(countryCode,PageRequest.of(page, 10));

        return new PageResponse<>(
                customerPage.getContent(),page,customerPage.getTotalPages(),customerPage.getTotalElements());
    }

    @Override
    public PageResponse<List<Customer>> getAllPhoneNumbers(Integer pageNumber) {
        Integer page = Optional.ofNullable(pageNumber).orElse(0);
        Page<Customer> customerPage = customerRepository.findAll(PageRequest.of(page, 10));
        return new PageResponse<>(
                customerPage.getContent(),page,customerPage.getTotalPages(),customerPage.getTotalElements());
    }
}
