package me.erano.com.example1;

//unshared concrete flyweight
public class UserBannedErrorMessage implements ErrorMessage{

	private String caseNo;
	
	private String caseRemarks;
	
	private String banDuration;
	
	@Override
	public void getText(String errorCode) {
		
	}

	
}
