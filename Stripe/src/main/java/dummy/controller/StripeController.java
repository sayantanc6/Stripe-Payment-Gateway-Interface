package dummy.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import dummy.entity.StripeEntity;
import dummy.model.Currency;
import dummy.model.StripeModel;
import dummy.repo.OrderRepository;
import dummy.service.paymentsService;

@RestController
public class StripeController {
	
	@Autowired
	DozerBeanMapper mapper;
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	paymentsService service;
	
	@Value("${STRIPE_PUBLIC_KEY}")
	public String stripePublicKey;

	@GetMapping("/")
	public ModelAndView name(ModelMap map) {
		map.addAttribute("amount", 100);
		map.addAttribute("stripePublicKey", stripePublicKey);
		map.addAttribute("currency", Currency.USD);
		return new ModelAndView("Welcome",map);
	}
	
	@PostMapping(value = "/charge",produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView charge(StripeModel chargeRequest, ModelMap map) throws StripeException {
		chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.USD);
        Charge charge = service.charge(chargeRequest);
        map.addAttribute("id", charge.getId());
        map.addAttribute("status", charge.getStatus());
        map.addAttribute("chargeId", charge.getId());
        map.addAttribute("balance_transaction", charge.getBalanceTransaction());
        repo.save(mapper.map(chargeRequest, StripeEntity.class));
        return new ModelAndView("result",map);
    }
	
	@ExceptionHandler(StripeException.class)
    public ModelAndView handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return new ModelAndView("result");
    }
}
