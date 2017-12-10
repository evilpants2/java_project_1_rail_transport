package model.dao;

import java.util.List;

public interface GenericDAO<Entity> extends AutoCloseable {

    int insert(Entity e);
    List<Entity> findAll();
    Entity findById(int id);
    boolean update(Entity e);
    boolean delete(int id);

}
