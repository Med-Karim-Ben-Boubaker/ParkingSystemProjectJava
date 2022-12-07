package JavaProjects.ParkingProject;
import java.lang.String;

public class Vehicle {
    
    private String vehicleIdNumber;
    private VehicleSize vehicleSize;
    private MemberShip membership;

    public Vehicle(String vehicleIdNumber,VehicleSize vehicleSize, MembershipType membershipType){
        this.vehicleIdNumber = vehicleIdNumber;
        this.vehicleSize = vehicleSize;
        this.membership = new MemberShip(membershipType, vehicleSize);
    }

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
