package JavaProjects.ParkingProject;
import java.lang.String;

/*This Class illustrates fundamental vehicle characteristics.*/

public class Vehicle {
    
    private String vehicleIdNumber;
    private VehicleSize vehicleSize; //VehicleSize is an enumeration that has NORMAL and BIG sizes.
    private MemberShip membership; //Examine the Membership class to better comprehend its structure.

    //Vehicle Constructor.
    public Vehicle(String vehicleIdNumber,VehicleSize vehicleSize, MembershipType membershipType){
        this.vehicleIdNumber = vehicleIdNumber;
        this.vehicleSize = vehicleSize;
        this.membership = new MemberShip(membershipType, vehicleSize);
    }


    //Getter and Setters.
    public MemberShip getMemberShip() {
        return membership;
    }

    public VehicleSize getVehicleSize(){
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize){
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleIdNumber(){
        return vehicleIdNumber;
    }

    public void setVehicleIdNumber(String vehicleIdNumber){
        this.vehicleIdNumber = vehicleIdNumber;
    }
}
