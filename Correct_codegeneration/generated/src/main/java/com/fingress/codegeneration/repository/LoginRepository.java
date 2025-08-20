package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LoginDao;
import com.bsit.codegeneration.record.Login;

public class LoginRepository {

    private final Jdbi jdbi;

    public LoginRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Login> getAllLogins() {
        return jdbi.withExtension(LoginDao.class, logindao -> logindao.findAll());
    }

    public Optional<Login> getLoginById(Long id) {
        return jdbi.withExtension(LoginDao.class, dao -> dao.findById(id));
    }

    public Long createLogin(Login entity) {
        return jdbi.withExtension(LoginDao.class, dao -> dao.insert(entity));
    }

    public int updateLogin(Login entity) {
        return jdbi.withExtension(LoginDao.class, dao -> dao.update(entity));
    }

    public void deleteLogin(Long id) {
        jdbi.useExtension(LoginDao.class, dao -> dao.delete(id));
    }
}
