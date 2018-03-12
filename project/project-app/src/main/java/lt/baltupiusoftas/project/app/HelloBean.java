package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.service.messaging.MessagingService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * @author Audrius Tvarijonas
 */
@Model
public class HelloBean {

    @Inject
    private MessagingService messagingService;

    public String constructMessage() {
        return messagingService.helloMessage(1);
    }
}
