package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkFunctionsDao;
import com.bsit.codegeneration.record.FgSdkFunctions;

public class FgSdkFunctionsRepository {

    private final Jdbi jdbi;

    public FgSdkFunctionsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkFunctions> getAllFgSdkFunctionss() {
        return jdbi.withExtension(FgSdkFunctionsDao.class, fgsdkfunctionsdao -> fgsdkfunctionsdao.findAll());
    }

    public Optional<FgSdkFunctions> getFgSdkFunctionsById(String id) {
        return jdbi.withExtension(FgSdkFunctionsDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkFunctions(FgSdkFunctions entity) {
        return jdbi.withExtension(FgSdkFunctionsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkFunctions(FgSdkFunctions entity) {
        return jdbi.withExtension(FgSdkFunctionsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkFunctions(String id) {
        jdbi.useExtension(FgSdkFunctionsDao.class, dao -> dao.delete(id));
    }
}
