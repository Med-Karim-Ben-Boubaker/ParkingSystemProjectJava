package JavaProjects.ParkingProject;
/*To do list:
 * Check for constructor MemberShip(MembershipType membership, VehicleSize vehicleSize)
 */
public class MemberShip{
    final static int percentPerHourForGoldMembers = 2;
    final static int percentPerHourForNormalMembers = 5;
    final static double baseTicketPriceForGoldMembers = 3;
    final static double baseTicketPriceForNormalMembers = 5;
    final static double extraSpaceChargesCoefficientForNormalMembers = 2;
    final static double extraSpaceChargesCoefficientForGoldMembers = 1.5;

	private MembershipType membership;
    private double percentPerHour;
    private double baseTicketPrice;
    private double extraSpaceChargesCoefficient;

    public MemberShip(MembershipType membership, VehicleSize vehicleSize){

        if(membership.equals(MembershipType.NORMAL)){
            this.membership = membership;
            this.percentPerHour = percentPerHourForNormalMembers;
            this.baseTicketPrice = baseTicketPriceForNormalMembers;
            if(vehicleSize.equals(VehicleSize.NORMAL))
            this.extraSpaceChargesCoefficient = 1;
            else 
            this.extraSpaceChargesCoefficient = extraSpaceChargesCoefficientForNormalMembers;
        }
            
        if(membership.equals(MembershipType.GOLD)){
            this.membership = membership;
            this.percentPerHour = percentPerHourForGoldMembers;
            this.baseTicketPrice = baseTicketPriceForGoldMembers;
            if(vehicleSize.equals(VehicleSize.NORMAL))
            this.extraSpaceChargesCoefficient = 1;
            else 
            this.extraSpaceChargesCoefficient = extraSpaceChargesCoefficientForGoldMembers;
        }
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }

    public double getPercentPerHour() {
        return percentPerHour;
    }

    public void setBaseTicketPrice(double baseTicketPrice) {
        this.baseTicketPrice = baseTicketPrice;
    }

    public void setMembership(MembershipType membership) {
        this.membership = membership;
    }

    public double getExtraSpaceChargesCoefficient() {
        return extraSpaceChargesCoefficient;
    }

    public MembershipType getMembershipType () {
        return membership;
    }
}
