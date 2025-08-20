package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUploadEntityAttributeDao;
import com.bsit.codegeneration.record.FgUploadEntityAttribute;

public class FgUploadEntityAttributeRepository {

    private final Jdbi jdbi;

    public FgUploadEntityAttributeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUploadEntityAttribute> getAllFgUploadEntityAttributes() {
        return jdbi.withExtension(FgUploadEntityAttributeDao.class, fguploadentityattributedao -> fguploadentityattributedao.findAll());
    }

    public Optional<FgUploadEntityAttribute> getFgUploadEntityAttributeById(String id) {
        return jdbi.withExtension(FgUploadEntityAttributeDao.class, dao -> dao.findById(id));
    }

    public String createFgUploadEntityAttribute(FgUploadEntityAttribute entity) {
        return jdbi.withExtension(FgUploadEntityAttributeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUploadEntityAttribute(FgUploadEntityAttribute entity) {
        return jdbi.withExtension(FgUploadEntityAttributeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUploadEntityAttribute(String id) {
        jdbi.useExtension(FgUploadEntityAttributeDao.class, dao -> dao.delete(id));
    }
}
