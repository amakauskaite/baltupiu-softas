package lt.baltupiusoftas.project.service.messaging;

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

    public String helloMessage(Integer messageCode) {

        String message;

        switch (messageCode) {
            case 1:
                message = "Hello world!";
                break;
            case 2:
                message = "Heelloo woorld!";
                break;
            default:
                message = "Hi";
                break;
        }

        return message;
    }
}
