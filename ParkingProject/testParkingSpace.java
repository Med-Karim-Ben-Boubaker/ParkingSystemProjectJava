package JavaProjects.ParkingProject;

public class testParkingSpace {
    public static void main(String[] args) throws ParkingIsFullException{
        ParkingSpace parkingSpace = new ParkingSpace();
        Ticket ticket;
        parkingSpace.initializeParkingSlots(5, 5);
        Vehicle vehicle = new Vehicle("22314", VehicleSize.BIG, MembershipType.NORMAL);
        ticket= parkingSpace.park(vehicle);
        parkingSpace.unPark(ticket, vehicle);
    }
}
