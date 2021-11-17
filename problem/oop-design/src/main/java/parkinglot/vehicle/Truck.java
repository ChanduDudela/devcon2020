package parkinglot.vehicle;

public class Truck extends Vehicle {
    public Truck(
        String driverName, String driverLicenseNumber, String vehiclePlateNumber,
        String color) {
        super(driverName, driverLicenseNumber, vehiclePlateNumber, color, VehicleSize.LARGE);
    }
}
