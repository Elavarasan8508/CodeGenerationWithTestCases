package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.SpringSessionAttributesDao;
import com.bsit.codegeneration.record.SpringSessionAttributes;

public class SpringSessionAttributesRepository {

    private final Jdbi jdbi;

    public SpringSessionAttributesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<SpringSessionAttributes> getAllSpringSessionAttributess() {
        return jdbi.withExtension(SpringSessionAttributesDao.class, springsessionattributesdao -> springsessionattributesdao.findAll());
    }

    public Optional<SpringSessionAttributes> getSpringSessionAttributesById(String id) {
        return jdbi.withExtension(SpringSessionAttributesDao.class, dao -> dao.findById(id));
    }

    public String createSpringSessionAttributes(SpringSessionAttributes entity) {
        return jdbi.withExtension(SpringSessionAttributesDao.class, dao -> dao.insert(entity));
    }

    public int updateSpringSessionAttributes(SpringSessionAttributes entity) {
        return jdbi.withExtension(SpringSessionAttributesDao.class, dao -> dao.update(entity));
    }

    public void deleteSpringSessionAttributes(String id) {
        jdbi.useExtension(SpringSessionAttributesDao.class, dao -> dao.delete(id));
    }
}
