package parkinglot.parking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import parkinglot.vehicle.Vehicle;

@Builder
@Getter
@Setter
public class ParkingSpot {
    private final int id;
    private final int levelId;
    private final ParkingSpotSize parkingSpotSize;
    private Vehicle vehicle;
    private boolean isOccupied = false;

    public ParkingSpot(int id, int levelId, ParkingSpotSize size) {
        this.id = id;
        this.levelId = levelId;
        this.parkingSpotSize = size;
    }

    public boolean canVehicleFit(Vehicle vehicle) {
        return parkingSpotSize.isVehicleParkingPossible(vehicle);
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.isOccupied && vehicle != this.vehicle) {
            throw new IllegalArgumentException("slot not empty");
        }

        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void empty() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
