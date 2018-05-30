package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.data.Payment;
import lt.baltupiusoftas.project.service.PaymentService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 */
public class DefaultPaymentServiceImpl implements PaymentService {

    @Override
    public Boolean pay(Cart cart, Payment payment) {
        String header = "Basic " + java.util.Base64.getEncoder().encodeToString( "technologines:platformos".getBytes() );

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://mock-payment-processor.appspot.com/v1/payment");
        Response response = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, header).post(Entity.json(payment));
        return response.getStatus() == 201;
    }
}
