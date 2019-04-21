package Parking_System.Model;

public class RevokedUsers {

	public String userName;
	public String email;
	public String reason;
	

	public RevokedUsers(){

    }

    public RevokedUsers(String userName, String email, String reason){

    	this.userName = userName;
    	this.email = email;
    	this.reason = reason;
    }


    public void setUserName(String userName){
    	this.userName = userName;
    }

    public String getUserName(){
    	return userName;
    }

    public void setEmail(String email){
    	this.email = email;
    }

    public String getEmail(){
    	return email;
    }

    public void setReason(String reason){
    	this.reason = reason;
    }

    public String getReason(){
    	return reason;
    }

}
