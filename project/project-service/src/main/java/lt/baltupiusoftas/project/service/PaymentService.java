package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.data.Payment;

/**
*/
public interface PaymentService {

    Boolean pay(Cart cart, Payment payment);
}
