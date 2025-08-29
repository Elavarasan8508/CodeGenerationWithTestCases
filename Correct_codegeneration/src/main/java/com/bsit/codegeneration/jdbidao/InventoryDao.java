package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Inventory;

public interface InventoryDao {

    @SqlUpdate("INSERT INTO inventory (film_id, store_id) VALUES (:filmId, :storeId)")
    @GetGeneratedKeys
    public int insert(@Bind("filmId") int filmId, @Bind("storeId") int storeId);

    @SqlQuery("SELECT * FROM inventory WHERE inventory_id = :id")
    public Inventory findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM inventory")
    public List<Inventory> findAll();

    @SqlUpdate("UPDATE inventory SET film_id = :filmId, store_id = :storeId WHERE inventory_id = :inventoryId")
    public void update(@BindBean Inventory inventory);

    @SqlUpdate("DELETE FROM inventory WHERE inventory_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM inventory WHERE store_id = :storeId")
    public List<Inventory> findByStoreId(@Bind("storeId") int storeId);

    @SqlQuery("SELECT * FROM inventory WHERE film_id = :filmId")
    public List<Inventory> findByFilmId(@Bind("filmId") int filmId);
}
