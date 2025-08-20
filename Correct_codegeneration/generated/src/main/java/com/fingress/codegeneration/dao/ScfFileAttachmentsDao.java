package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.ScfFileAttachments;
import com.bsit.codegeneration.mapper.ScfFileAttachmentsMapper;
import java.util.*;

@RegisterRowMapper(ScfFileAttachmentsMapper.class)
public interface ScfFileAttachmentsDao {

    @SqlQuery("SELECT * FROM SCF_FILE_ATTACHMENTS")
    public List<ScfFileAttachments> findAll();

    @SqlQuery("SELECT * FROM SCF_FILE_ATTACHMENTS WHERE id = :id")
    public Optional<ScfFileAttachments> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO SCF_FILE_ATTACHMENTS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_TYPE, FILE_SIZE, FILE_ATTACHMENT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REF_ID, ENTITY_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :ANCHOR_CRN, :FILE_NAME, :FILE_TYPE, :FILE_SIZE, :FILE_ATTACHMENT, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :ENTITY_REF_ID, :ENTITY_VERSION_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() ScfFileAttachments entity);

    @SqlQuery("UPDATE SCF_FILE_ATTACHMENTS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, ANCHOR_CRN = :ANCHOR_CRN, FILE_NAME = :FILE_NAME, FILE_TYPE = :FILE_TYPE, FILE_SIZE = :FILE_SIZE, FILE_ATTACHMENT = :FILE_ATTACHMENT, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, ENTITY_REF_ID = :ENTITY_REF_ID, ENTITY_VERSION_ID = :ENTITY_VERSION_ID WHERE id = :id")
    public int update(@BindBean() ScfFileAttachments entity);

    @SqlQuery("DELETE FROM SCF_FILE_ATTACHMENTS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
