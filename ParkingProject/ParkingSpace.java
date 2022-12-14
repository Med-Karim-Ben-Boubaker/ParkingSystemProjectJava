package JavaProjects.ParkingProject;
import java.util.Date;
import java.util.ArrayList;
/*
* This class represents a full parking space with several parking slots.
* If the parking has many floors, we may also describe this class as a floor.
* Both large and normal parking spaces are present in this parking area.
* Extensions are possible.
 */
public class ParkingSpace implements ParkingInterface {
    private static ParkingSpace parkingSpace;
    private final ArrayList<ParkingSlot> bigParkingSlots;
    private final ArrayList<ParkingSlot> normalParkingSlots;

    //Constructor
    public ParkingSpace(){
        this.bigParkingSlots = new ArrayList<>();
        this.normalParkingSlots = new ArrayList<>();
    }

    public static ParkingSpace getParkingLot() {
        if(parkingSpace == null){
            parkingSpace = new  ParkingSpace();
            return parkingSpace;
        }

        return parkingSpace;
    }

    public static void freeParkingLot(){
        parkingSpace = null;
    }

    //This function will initialize all parking slots inside a parking space.
    public boolean initializeParkingSlots(int numberOfBigParkingSlots, int numberOfNormalParkingSlots){

        for(int i=0; i<numberOfBigParkingSlots; i++){
            bigParkingSlots.add(new ParkingSlot(i, ParkingSlotSize.BIG));
        }

        for(int i=0; i<numberOfNormalParkingSlots; i++){
            normalParkingSlots.add(new ParkingSlot(i, ParkingSlotSize.NORMAL));
        }

        System.out.println("A Parking Space has been added with "+numberOfBigParkingSlots+" Big Parking lots and "+numberOfNormalParkingSlots+" Normal Parking lots.");

        return true;
    }

    //This function illustrates the process of parking a vehicle by producing a ticket and occupying the proper parking space.
    public Ticket park(Vehicle vehicle) throws ParkingIsFullException {
        
        ParkingSlot nextParkingSlot;
        nextParkingSlot = getNextAvailablParkingSlot(vehicle.getVehicleSize()); // Searching for the next available parking slot,
        nextParkingSlot.occupyParkingSlot(vehicle);                             // if all the wanted parking slots are full, an exception will be thrown.

        Ticket ticket = new Ticket(nextParkingSlot); //Generating a new ticket.
        System.out.println("\nSystem: The Parking Slot number  "+nextParkingSlot.getParkingSlotNumber()+" has been allocated\n"); //System notification.
        String parkingMessage = ticket.getParkingMessage();
        System.out.println(parkingMessage); //Print ticket message.

        return ticket;
    }

    //If no space is discovered, a ParkingIsFullException is issued. This function searches for the next available parking slot for the vehicle with the specified size (vehicleSize).
    private ParkingSlot getNextAvailablParkingSlot(VehicleSize vehicleSize) throws ParkingIsFullException {
        int i = 1;

        if(vehicleSize.equals(VehicleSize.BIG)){
            for(i=1; i<bigParkingSlots.size(); i++){
                if(bigParkingSlots.get(i).isEmpty())
                    return bigParkingSlots.get(i);
            }

            throw new ParkingIsFullException("No Empty big Slot is available");

        } else {
            for(i=1; i<normalParkingSlots.size(); i++){
                if(normalParkingSlots.get(i).isEmpty())
                    return normalParkingSlots.get(i);
            }

            throw new ParkingIsFullException("No Empty Normal Slot is available");

        }
    }

    //By generating a ticket and clearing the designated parking space, this function demonstrates the process of exiting a vehicle.
    public Ticket unPark(Ticket ticket, Vehicle vehicle){
        Date unParkingDate = new Date();
        ticket.setUnParkingDate(unParkingDate);
        ticket.setTicketPrice(ticket.calculateTicketPrice(ticket.getDate(), unParkingDate, vehicle));

        String unParkingMessage = ticket.getUnParkingMessage();

        System.out.println(unParkingMessage);

        ticket.getParkingSlot().freeParkingSlot();

        return ticket;
    }


    
    

}
