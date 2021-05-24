package dummy.model;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class StripeModel {

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("amount")
    private int amount; 
	
	@JsonProperty("currency")
    private Currency currency;
	
	@JsonProperty("stripeEmail")
    private String stripeEmail;
	
	@JsonProperty("stripeToken")
    private String stripeToken;

	@Mapping("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Mapping("amount")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Mapping("currency")
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Mapping("stripeEmail")
	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	@Mapping("stripeToken")
	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	@Override
	public String toString() {
		return "StripeModel [description=" + description + ", amount=" + amount + ", currency=" + currency
				+ ", stripeEmail=" + stripeEmail + ", stripeToken=" + stripeToken + "]";
	}
}
