package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUploadAdviceDao;
import com.bsit.codegeneration.record.FgUploadAdvice;

public class FgUploadAdviceRepository {

    private final Jdbi jdbi;

    public FgUploadAdviceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUploadAdvice> getAllFgUploadAdvices() {
        return jdbi.withExtension(FgUploadAdviceDao.class, fguploadadvicedao -> fguploadadvicedao.findAll());
    }

    public Optional<FgUploadAdvice> getFgUploadAdviceById(Long id) {
        return jdbi.withExtension(FgUploadAdviceDao.class, dao -> dao.findById(id));
    }

    public Long createFgUploadAdvice(FgUploadAdvice entity) {
        return jdbi.withExtension(FgUploadAdviceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUploadAdvice(FgUploadAdvice entity) {
        return jdbi.withExtension(FgUploadAdviceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUploadAdvice(Long id) {
        jdbi.useExtension(FgUploadAdviceDao.class, dao -> dao.delete(id));
    }
}
