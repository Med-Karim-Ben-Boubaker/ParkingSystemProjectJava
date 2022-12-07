package JavaProjects.ParkingProject;
import java.lang.String;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Ticket {
    private ParkingSlot parkingSlot;
    private double ticketPrice;
    private Date parkingDate;
    private Date unParkingDate;

    public Ticket(ParkingSlot parkingSlot){
        this.parkingSlot = parkingSlot;
        this.parkingDate = new Date();
    }

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

    public double calculateTicketPrice(Date parkingDate, Date UnparkingDate, Vehicle vehicle){
        double ticketPrice;
        long diffInMillies = Math.abs(UnparkingDate.getTime() - parkingDate.getTime());
        long hours = TimeUnit.MILLISECONDS.toHours(diffInMillies);
        ticketPrice = vehicle.getMemberShip().getBaseTicketPrice()*vehicle.getMemberShip().getPercentPerHour()*hours*vehicle.getMemberShip().getExtraSpaceChargesCoefficient()
        + vehicle.getMemberShip().getBaseTicketPrice();

        return ticketPrice;
    }
    public String toString(){
        return "Tickets info: \nVehicle ID: "+parkingSlot.getVehicleParked().getVehicleIdNumber()+
        "\nParking Slot Number: "+parkingSlot.getParkingSlotNumber()+
        "\nVehicle Size: "+parkingSlot.getVehicleParked().getVehicleSize();
    }
}
