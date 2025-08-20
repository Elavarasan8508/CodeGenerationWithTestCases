package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CustomerRegistrationDao;
import com.bsit.codegeneration.record.CustomerRegistration;

public class CustomerRegistrationRepository {

    private final Jdbi jdbi;

    public CustomerRegistrationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CustomerRegistration> getAllCustomerRegistrations() {
        return jdbi.withExtension(CustomerRegistrationDao.class, customerregistrationdao -> customerregistrationdao.findAll());
    }

    public Optional<CustomerRegistration> getCustomerRegistrationById(Long id) {
        return jdbi.withExtension(CustomerRegistrationDao.class, dao -> dao.findById(id));
    }

    public Long createCustomerRegistration(CustomerRegistration entity) {
        return jdbi.withExtension(CustomerRegistrationDao.class, dao -> dao.insert(entity));
    }

    public int updateCustomerRegistration(CustomerRegistration entity) {
        return jdbi.withExtension(CustomerRegistrationDao.class, dao -> dao.update(entity));
    }

    public void deleteCustomerRegistration(Long id) {
        jdbi.useExtension(CustomerRegistrationDao.class, dao -> dao.delete(id));
    }
}
