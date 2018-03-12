package lt.baltupiusoftas.project.service.messaging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.CDIProvider;
import javax.inject.Inject;

/**
 * @author Audrius Tvarijonas
 */
public class MessagingServiceTest {

    @Test
    public void helloMessage() {
        Assert.assertTrue(true);
    }

}
