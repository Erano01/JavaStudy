package me.erano.com;

import me.erano.com.example1.ErrorMessageFactory;
import me.erano.com.example1.ErrorMessageFactory.ErrorType;
import me.erano.com.example1.SystemErrorMessage;
import me.erano.com.example1.UserBannedErrorMessage;

public class Application {

	public static void main(String[] args) {
		
		//example1
		SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getError(ErrorType.GenericSystemError);
		System.out.println(msg1.getText("4056"));
		
		UserBannedErrorMessage msg2 = ErrorMessageFactory.getInstance().getUserBannedMessage("1202");
		System.out.println(msg2.getText(null));
		
		//example2
		
		
		//example3
		
		//example4
		
		//example5
		
		//example6
	}
}
