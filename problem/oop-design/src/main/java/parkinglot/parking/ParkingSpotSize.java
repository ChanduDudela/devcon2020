package parkinglot.parking;

import java.util.Arrays;
import java.util.List;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleSize;

public enum ParkingSpotSize {
    SMALL(Arrays.asList(VehicleSize.SMALL)),
    MEDIUM(Arrays.asList(VehicleSize.SMALL, VehicleSize.MEDIUM)),
    LARGE(Arrays.asList(VehicleSize.SMALL, VehicleSize.MEDIUM, VehicleSize.LARGE));

    private final List<VehicleSize> vehicles;

    ParkingSpotSize(List<VehicleSize> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean isVehicleParkingPossible(Vehicle vehicle) {
        return this.vehicles.contains(vehicle.getSize());
    }
}
