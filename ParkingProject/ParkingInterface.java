package JavaProjects.ParkingProject;

interface ParkingInterface {
    public Ticket park(Vehicle vehicle) throws ParkingIsFullException;
    public Ticket unPark(Ticket ticket, Vehicle vehicle);
}
