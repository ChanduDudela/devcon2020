package parkinglot.vehicle;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public abstract class Vehicle {
    String driverName;
    String driverLicenseNumber;
    String vehiclePlateNumber;
    String color;
    VehicleSize size;

    public Vehicle(
        String driverName, String driverLicenseNumber, String vehiclePlateNumber,
        String color, VehicleSize size) {
        this.driverName = driverName;
        this.driverLicenseNumber = driverLicenseNumber;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.color = color;
        this.size = size;
    }
}
