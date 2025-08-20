package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCampaignDao;
import com.bsit.codegeneration.record.FgModCampaign;

public class FgModCampaignRepository {

    private final Jdbi jdbi;

    public FgModCampaignRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCampaign> getAllFgModCampaigns() {
        return jdbi.withExtension(FgModCampaignDao.class, fgmodcampaigndao -> fgmodcampaigndao.findAll());
    }

    public Optional<FgModCampaign> getFgModCampaignById(String id) {
        return jdbi.withExtension(FgModCampaignDao.class, dao -> dao.findById(id));
    }

    public String createFgModCampaign(FgModCampaign entity) {
        return jdbi.withExtension(FgModCampaignDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCampaign(FgModCampaign entity) {
        return jdbi.withExtension(FgModCampaignDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCampaign(String id) {
        jdbi.useExtension(FgModCampaignDao.class, dao -> dao.delete(id));
    }
}
