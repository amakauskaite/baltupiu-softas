package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.data.Payment;
import lt.baltupiusoftas.project.service.PaymentService;

import javax.enterprise.inject.Alternative;

/**
*/
@Alternative
public class AlternativePaymentServiceImpl implements PaymentService {

    @Override
    public Boolean pay(Cart cart, Payment payment) {
        return false;
    }
}
