package Parking_System.Model;

public class Reservations {

	public String areaName;
	public String spotId;
	public String user;
	public String camera;
	public String cart;
	public String history;
	public String available;
	public int floor;

	public Reservations(){

    }

    public Reservations(String areaName, String spotId, String user, String camera, String cart, String history, String available, int floor){

    	this.areaName = areaName;
    	this.spotId = spotId;
    	this.user = user;
    	this.camera = camera;
    	this.cart = cart;
    	this.history = history;
    	this.available = available;
    	this.floor = floor;
    }


    public void setAreaName(String areaName){
    	this.areaName = areaName;
    }

    public String getAreaName(){
    	return areaName;
    }

    public void setSpotId(String spotId){
    	this.spotId = spotId;
    }

    public String getSpotId(){
    	return spotId;
    }

    public void setUser(String user){
    	this.user = user;
    }

    public String getUser(){
    	return user;
    }

    public void setCamera(String camera){
    	this.camera = camera;
    }

    public String getCamera(){
    	return camera;
    }

    public void setCart(String cart){
    	this.cart = cart;
    }

    public String getCart(){
    	return cart;
    }

    public void setHistory(String history){
    	this.history = history;
    }

    public String getHistory(){
    	return history;
    }

    public void setAvailable(String available){
    	this.available = available;
    }

    public String getAvailable(){
    	return available;
    }
    
    public void setFloor(int floor){
    	this.floor = floor;
    }

    public int getFloor(){
    	return floor;
    }

}
