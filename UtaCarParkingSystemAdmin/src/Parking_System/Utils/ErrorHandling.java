package Parking_System.Utils;

import java.io.*;
import java.util.regex.Matcher;		
import java.util.regex.Pattern;


public class ErrorHandling{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean checkParkingAreaName(String name){

		if(name.equals("") || name==null){
			return false;
		}
		else{
			return true;
		}
	}


//	public static boolean checkUserName(String userName){
//
//		if(userName.equals("") || userName.equals(null)){
//			return false;
//		}
//		else{
//			return true;
//		}
//	}

	public static boolean checkUserNameLength(String userName){

		if(userName.length()<3 || userName.length()>11){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkPassword(String password){

		if(password.equals("") || password.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkPasswordMatch(String password){

		String pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
		if(!password.matches(pattern)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkFname(String fname){

		if(fname.equals("") || fname.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkLname(String lname){

		if(lname.equals("") || lname.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkUtaId(String UTAID){

		if(UTAID.equals("") || UTAID.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkUtaIdLength(String UTAID){
		if(!(UTAID.length()==10)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkPhone(String Phone){

		if(Phone.equals("") || Phone.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkPhoneLength(String Phone){

		if(!(Phone.length()==10)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkEmail(String email){

		if(email.equals("") || email.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkEmailMatch(String email){

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
		if(!matcher.find()){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkAddress(String address){

		if(address.equals("") || address.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkCity(String city){

		if(city.equals("") || city.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkZip(String Zip){

		if(Zip.equals("") || Zip.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkZipLength(String Zip){

		if(!(Zip.length() == 5)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkDriverLicense(String driverLicense){

		if(driverLicense.equals("") || driverLicense.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkSpotId(String spotId){

		if(spotId.equals("") || spotId.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkRole(String role){

		if(role.equals("") || role.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static boolean checkYesNo(String input){

		if(input.equals("YES") || input.equals("NO") || input.equals("yes") || input.equals("no")){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean checkReason(String reason){

		if(reason.equals("") || reason.equals(null)){
			return false;
		}
		else{
			return true;
		}
	}

	public static boolean checkInteger(String integer){
		
		boolean numeric = true;
		
		try {
            int num = Integer.parseInt(integer);
        } 
		catch (NumberFormatException e) {
            numeric = false;
        }
		
		if (numeric){
			return true;
		}
		else{
			return false;
		}
	}
}