package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCmsBlockDao;
import com.bsit.codegeneration.record.FgModCmsBlock;

public class FgModCmsBlockRepository {

    private final Jdbi jdbi;

    public FgModCmsBlockRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCmsBlock> getAllFgModCmsBlocks() {
        return jdbi.withExtension(FgModCmsBlockDao.class, fgmodcmsblockdao -> fgmodcmsblockdao.findAll());
    }

    public Optional<FgModCmsBlock> getFgModCmsBlockById(String id) {
        return jdbi.withExtension(FgModCmsBlockDao.class, dao -> dao.findById(id));
    }

    public String createFgModCmsBlock(FgModCmsBlock entity) {
        return jdbi.withExtension(FgModCmsBlockDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCmsBlock(FgModCmsBlock entity) {
        return jdbi.withExtension(FgModCmsBlockDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCmsBlock(String id) {
        jdbi.useExtension(FgModCmsBlockDao.class, dao -> dao.delete(id));
    }
}
