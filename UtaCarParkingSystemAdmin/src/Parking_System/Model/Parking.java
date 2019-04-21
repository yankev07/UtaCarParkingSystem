package Parking_System.Model;

public class Parking {

	public String areaName;
	public int space;
	public int floors;
	public int occupied;
	public int unavailable;
	public int reserved;

	public Parking(){

    }

    public Parking(String areaName, int space, int floors, int occupied, int unavailable, int reserved){

    	this.areaName = areaName;
    	this.space = space;
    	this.floors = floors;
    	this.occupied = occupied;
    	this.unavailable = unavailable;
    	this.reserved = reserved;
    }


    public void setAreaName(String areaName){
    	this.areaName = areaName;
    }

    public String getAreaName(){
    	return areaName;
    }

    public void setSpace(int space){
    	this.space = space;
    }

    public int getSpace(){
    	return space;
    }

    public void setFloors(int floors){
    	this.floors = floors;
    }

    public int getFloors(){
    	return floors;
    }

    public void setOccupied(int occupied){
    	this.occupied = occupied;
    }

    public int getOccupied(){
    	return occupied;
    }

    public void setUnavailable(int unavailable){
    	this.unavailable = unavailable;
    }

    public int getUnavailable(){
    	return unavailable;
    }

    public void setReserved(int reserved){
    	this.reserved = reserved;
    }

    public int getReserved(){
    	return reserved;
    }

}
