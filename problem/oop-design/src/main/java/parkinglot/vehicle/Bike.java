package parkinglot.vehicle;

import lombok.Builder;

@Builder
public class Bike extends Vehicle {
    public Bike(
        String driverName, String driverLicenseNumber, String vehiclePlateNumber,
        String color) {
        super(driverName, driverLicenseNumber, vehiclePlateNumber, color, VehicleSize.SMALL);
    }
}
