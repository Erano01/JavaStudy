package me.erano.com.example1;

//concrete flyweight
public class SystemErrorMessage implements ErrorMessage {

	//some error message $errorCode
	private String messageTemplate;
	
	//http://somedomain.com/help?error=
	private String helpUrlBase;
	
	public SystemErrorMessage (String messageTemplate, String helpUrlBase) {
		this.messageTemplate = messageTemplate;
		this.helpUrlBase = helpUrlBase;
	}

	@Override
	public String getText(String errorCode) {
		return messageTemplate.replace("$errorCode", errorCode) + helpUrlBase+errorCode;
	}
	
	
	
}
