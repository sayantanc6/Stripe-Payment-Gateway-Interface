<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action='/charge' method='POST' id='checkout-form'>
            <input type='hidden' value="${amount}" name='amount' />
            <label>Price: ${amount/100}</label>
            <script
                src="https://checkout.stripe.com/checkout.js"
                class="stripe-button"
                data-key="${stripePublicKey}"
                data-amount="${amount}"
                data-currency="${currency}"
                data-name="Sayantan"
                data-description="My Sample checkout"
                data-image="/Stripe/src/main/resources/static/logo-social-sq.png"
                data-locale="auto"
                data-zip-code="false">
            </script>
        </form>
</body>
</html>