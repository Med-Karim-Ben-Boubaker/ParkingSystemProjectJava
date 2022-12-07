package JavaProjects.ParkingProject;
import java.util.Date;
import java.util.ArrayList;
/*To do list:
 * Organize more user messages.
 */
public class ParkingSpace implements ParkingInterface {
    private static ParkingSpace parkingSpace;
    private final ArrayList<ParkingSlot> bigParkingSlots;
    private final ArrayList<ParkingSlot> normalParkingSlots;

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

    public Ticket park(Vehicle vehicle) throws ParkingIsFullException {
        ParkingSlot nextParkingSlot;
        
        nextParkingSlot = getNextAvailablParkingSlot(vehicle.getVehicleSize());
    
        nextParkingSlot.occupyParkingSlot(vehicle);

        System.out.println("######## - Parking Info - ########## \n"+
        "A Parking Slot has been allocated: \nParking Slot Number: "+
        nextParkingSlot.getParkingSlotNumber()+
        " Parking Slot Size: "+ nextParkingSlot.getParkingSlotSize()+ " For Vehicle with ID: "+
        vehicle.getVehicleIdNumber()+
        "\n#####################");

        return new Ticket(nextParkingSlot);
    
        
    }

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

    public Ticket unPark(Ticket ticket, Vehicle vehicle){
    
        Date unParkingDate = new Date();
        ticket.setUnParkingDate(unParkingDate);
        ticket.setTicketPrice(ticket.calculateTicketPrice(ticket.getDate(), unParkingDate, vehicle));
        
        
        System.out.println("Parking Slot Number: "+ticket.getParkingSlot().getParkingSlotNumber()+" is set Free\n"+
        "Ticket price is: "+ticket.getTicketPrice()+
        "\nEntry date: "+ticket.getDate()+"- Exit date: "+ unParkingDate + '\n' +
        ticket.toString());

        ticket.getParkingSlot().freeParkingSlot();

        return ticket;
    }


    
    

}
