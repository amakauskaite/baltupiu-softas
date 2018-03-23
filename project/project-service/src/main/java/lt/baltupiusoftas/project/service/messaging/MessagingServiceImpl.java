package lt.baltupiusoftas.project.service.messaging;

import lt.baltupiusoftas.project.domain.Message;
import lt.baltupiusoftas.project.persistence.MessageRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author Audrius Tvarijonas
 */
@Transactional
public class MessagingServiceImpl implements MessagingService {

    @Inject
    private MessageRepository messageRepository;

    public Message helloMessage() {

        Message message = new Message();
        message.setText("Hello world!");
        message.setAuthor("Author");

        messageRepository.create(message);

        return message;
    }
}
