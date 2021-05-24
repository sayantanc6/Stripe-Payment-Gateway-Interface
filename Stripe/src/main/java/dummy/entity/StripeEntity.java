package dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dummy.model.Currency;

@Entity
@Table(name = "ORDER_STRIPE")
public class StripeEntity {
	
	@Id
	@Column(name = "ORDER_ID",nullable = false,columnDefinition="VARCHAR(64)")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stripe_generator")
	@GenericGenerator(
					name = "book_generator",
					strategy = "dummy.entity.StringSequenceIdentifier"
					)
	private String orderId;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "AMOUNT")
    private int amount; 
	
	@Column(name = "CURRENCY")
    private Currency currency;
	
	@Column(name = "STRIPE_EMAIL")
    private String stripeEmail;
	
	@Column(name = "STRIPE_TOKEN")
    private String stripeToken;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getStripeEmail() {
		return stripeEmail;
	}
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	public String getStripeToken() {
		return stripeToken;
	}
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
	 
	@Override
	public String toString() {
		return "StripeEntity [description=" + description + ", amount=" + amount + ", stripeEmail=" + stripeEmail
				+ ", stripeToken=" + stripeToken + "]";
	}
    
}
