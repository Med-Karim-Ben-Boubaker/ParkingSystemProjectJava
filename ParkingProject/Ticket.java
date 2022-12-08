package JavaProjects.ParkingProject;
import java.lang.String;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*This class illustrates basic ticket characteristics. When a vehicle is parked, a ticket object including all parking information is generated.
When the vehicle is about to leave the parking lot, the ticket object is updated with new information. */

public class Ticket {
    private ParkingSlot parkingSlot;
    private double ticketPrice;
    private Date parkingDate;
    private Date unParkingDate;

    //Constructor
    public Ticket(ParkingSlot parkingSlot){
        this.parkingSlot = parkingSlot;
        this.parkingDate = new Date();
    }

    //Getters and Setters
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Date getDate() {
        return parkingDate;
    }

    public void setDate(Date parkingDate) {
        this.parkingDate = parkingDate;
    }

    public Date getUnParkingDate() {
        return unParkingDate;
    }

    public void setUnParkingDate(Date unParkingDate) {
        this.unParkingDate = unParkingDate;
    }

    //This function will calculate and return the ticket price based on an equation that takes into account multiple variables such as hours, size, and membership.
    public double calculateTicketPrice(Date parkingDate, Date UnparkingDate, Vehicle vehicle){
        double ticketPrice;
        long diffInMillies = Math.abs(UnparkingDate.getTime() - parkingDate.getTime());
        long hours = TimeUnit.MILLISECONDS.toHours(diffInMillies);
        ticketPrice = vehicle.getMemberShip().getBaseTicketPrice()*vehicle.getMemberShip().getPercentPerHour()*hours*vehicle.getMemberShip().getExtraSpaceChargesCoefficient()
        + vehicle.getMemberShip().getBaseTicketPrice()*vehicle.getMemberShip().getExtraSpaceChargesCoefficient();

        return ticketPrice;
    }

    //This function will generate a parking message printed in the ticket.
    public String getParkingMessage(){
        return "\nEntry Ticket info: \nVehicle ID: "+parkingSlot.getVehicleParked().getVehicleIdNumber()+
        "\nParking Slot Number: "+parkingSlot.getParkingSlotNumber()+
        "\nVehicle Size: "+parkingSlot.getVehicleParked().getVehicleSize()+
        "\nMembership: "+parkingSlot.getVehicleParked().getMemberShip().getMembershipType()+
        "\nParking Date: "+parkingDate.toString()+ "\n";
    }

    //This function will produce a message with the final price that will be printed on the exit ticket.
    public String getUnParkingMessage(){
        return "\nExit Ticket info: \nVehicle ID: "+parkingSlot.getVehicleParked().getVehicleIdNumber()+
        "\nParking Slot Number: "+parkingSlot.getParkingSlotNumber()+
        "\nVehicle Size: "+parkingSlot.getVehicleParked().getVehicleSize()+
        "\nMembership: "+parkingSlot.getVehicleParked().getMemberShip().getMembershipType()+
        "\nParking Date: "+parkingDate.toString()+
        "\nExit Date: "+unParkingDate.toString()+
        "\nFinal Ticket Price: "+ticketPrice+ "\n";
    }

    
}
