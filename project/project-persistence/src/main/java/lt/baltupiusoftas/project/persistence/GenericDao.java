package lt.baltupiusoftas.project.persistence;

/**
 * Generic DAO
 *
 * @param <T> Entity
 */
public interface GenericDao<T> {

    /**
     * Persists entity
     *
     * @param t Entity instance
     * @return Entity instance
     */
    T create(T t);

    /**
     * Deletes entity by id
     *
     * @param id Entity id
     */
    void delete(Object id);

    /**
     * Finds entity by id
     *
     * @param id Entity id
     * @return Entity instance
     */
    T find(Object id);

    /**
     * Updates entity
     *
     * @param t Entity instance
     * @return Entity instance
     */
    T update(T t);
}