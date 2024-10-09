package me.erano.com.example1;

import java.util.HashMap;
import java.util.Map;

//flyweight Factory. returns shared flyweight based on key
public class ErrorMessageFactory {
	
	//this serves as key for getting flyweight instance
	public enum ErrorType {GenericSystemError, PageNotFoundError, ServerError}
	
	private static final ErrorMessageFactory instance = new ErrorMessageFactory();
	
	private Map<ErrorType, SystemErrorMessage> errorMessages = new HashMap<>();
	
	private ErrorMessageFactory() {
		errorMessages.put(ErrorType.GenericSystemError, 
				new SystemErrorMessage("A genetic error of type $errorCode occured. Please refer to:\n",
						"http://google.com/q="));
		errorMessages.put(ErrorType.PageNotFoundError, 
				new SystemErrorMessage("Page not foun. An error of type $errorCode occured. Please refer to:\n",
						"http://google.com/q="));
	}
	
	public static ErrorMessageFactory getInstance() {
		return instance;
	}
	
	public SystemErrorMessage getError(ErrorType type) {
		return errorMessages.get(type);
	}
	
	public UserBannedErrorMessage getUserBannedMessage(String caseId) {
		return new UserBannedErrorMessage(caseId);
	}

	
}
