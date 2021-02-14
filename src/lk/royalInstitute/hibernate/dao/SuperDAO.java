package lk.royalInstitute.hibernate.dao;

import lk.royalInstitute.hibernate.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable>{

    public void setSession(Session session);

    public boolean add(Entity entity)throws Exception;

    public boolean delete(Entity entity)throws Exception;

    public boolean update(Entity entity)throws Exception;

    public Entity search (ID id) throws Exception;

    public List<Entity> getAll () throws Exception;
}