package lt.baltupiusoftas.project.persistence;

public interface GenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
}