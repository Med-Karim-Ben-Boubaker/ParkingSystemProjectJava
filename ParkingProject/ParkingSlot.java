package JavaProjects.ParkingProject;

public class ParkingSlot {
    
    private boolean isEmpty;
    private int parkingSlotNumber;
    private Vehicle vehicleParked;
    private ParkingSlotSize parkingSlotSize;

    ParkingSlot(int parkingSlotNumber, ParkingSlotSize parkingSlotSize){
        this.parkingSlotNumber = parkingSlotNumber;
        this.parkingSlotSize = parkingSlotSize;
        isEmpty = true;
    }

    public ParkingSlotSize getParkingSlotSize() {
        return parkingSlotSize;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(int parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }

    public void setVehicleParked(Vehicle vehicleParked) {
        this.vehicleParked = vehicleParked;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void freeParkingSlot(){
        vehicleParked = null;
        isEmpty = true;
    }

    public void occupyParkingSlot(Vehicle vehicleParked){
        this.vehicleParked = vehicleParked;
    }

    public boolean isEmpty(){
        return isEmpty;
    }
}
