package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class MessageRepositoryImpl implements MessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> findAllMessages(String author) {
        Query query = entityManager.createQuery("select a from Message a where a.author = :author", Message.class);
        query.setParameter("author", author);

        return query.getResultList();
    }
}