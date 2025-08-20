package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActGeBytearrayDao;
import com.bsit.codegeneration.record.FgActGeBytearray;

public class FgActGeBytearrayRepository {

    private final Jdbi jdbi;

    public FgActGeBytearrayRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActGeBytearray> getAllFgActGeBytearrays() {
        return jdbi.withExtension(FgActGeBytearrayDao.class, fgactgebytearraydao -> fgactgebytearraydao.findAll());
    }

    public Optional<FgActGeBytearray> getFgActGeBytearrayById(String id) {
        return jdbi.withExtension(FgActGeBytearrayDao.class, dao -> dao.findById(id));
    }

    public String createFgActGeBytearray(FgActGeBytearray entity) {
        return jdbi.withExtension(FgActGeBytearrayDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActGeBytearray(FgActGeBytearray entity) {
        return jdbi.withExtension(FgActGeBytearrayDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActGeBytearray(String id) {
        jdbi.useExtension(FgActGeBytearrayDao.class, dao -> dao.delete(id));
    }
}
