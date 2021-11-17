package parkinglot.vehicle;

public class Car extends Vehicle {
    public Car(
        String driverName, String driverLicenseNumber, String vehiclePlateNumber,
        String color) {
        super(driverName, driverLicenseNumber, vehiclePlateNumber, color, VehicleSize.MEDIUM);
    }
}
