package dummy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import dummy.model.StripeModel;

@Service
public class paymentsService {

	public Charge charge(StripeModel chargeRequest) throws StripeException {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
	}

}
