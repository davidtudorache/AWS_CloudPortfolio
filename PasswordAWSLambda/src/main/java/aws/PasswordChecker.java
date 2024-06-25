package aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class PasswordChecker implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
		
		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
		String method = request.getHttpMethod();
		
		if (method.equals("POST")) {
			if (request.getQueryStringParameters().containsKey("password")) {
				String password = request.getQueryStringParameters().get("password");
				
				int score = 0;
				boolean uppercase = false;
				boolean symbol = false;
				boolean digit = false;
				for (int i=0; i < password.length(); i++) {
					if (Character.isLetter(password.charAt(i))) {
						if (Character.isUpperCase(password.charAt(i))) {
							uppercase = true;
						}
					}
					//If not digit or letter must be symbol
					else if (Character.isDigit(password.charAt(i))) {
						digit = true;
					}
					else {
						symbol = true;
					}
				}
				if (password.length() >= 8) {
					score++;
				}
				else {
					score -=5;
				}
				if (password.length() >= 11) {
					score++;
				}
				if (uppercase == true) {
					score++;
				}
				if (digit == true) {
					score++;
				}
				if (symbol == true) {
					score++;
				}
				if (score < 0) {
					score = 0;
				}
				responseEvent.setStatusCode(200);
				responseEvent.setBody("score: "+score);
			}
			else {
				responseEvent.setBody("password required.");
				responseEvent.setStatusCode(404);
			}
		}

		return responseEvent;
	}

}