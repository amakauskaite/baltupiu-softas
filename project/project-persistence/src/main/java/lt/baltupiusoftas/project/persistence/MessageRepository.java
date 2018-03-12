package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Message;

import java.util.List;

public interface MessageRepository {

    List<Message> findAllMessages(String author);
}
