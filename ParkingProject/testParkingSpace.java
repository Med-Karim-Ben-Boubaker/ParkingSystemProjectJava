package JavaProjects.ParkingProject;

public class testParkingSpace {
    public static void main(String[] args) throws ParkingIsFullException{
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.initializeParkingSlots(5, 5);
        
        Vehicle vehicle_1 = new Vehicle("22314", VehicleSize.BIG, MembershipType.NORMAL);
        Ticket ticket= parkingSpace.park(vehicle_1);
        parkingSpace.unPark(ticket, vehicle_1);
    }
}
