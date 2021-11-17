package parkinglot.parking;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import parkinglot.vehicle.Vehicle;

@Getter
@Setter
@Builder
public class ParkingDetail {
    private int id;
    Vehicle vehicle;
    ParkingSpot parking;
    Instant entryTime;
    Instant exitTime;

    public ParkingDetail(
        Vehicle vehicle, ParkingSpot parking, Instant entryTime, Instant exitTime) {
        this.vehicle = vehicle;
        this.parking = parking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}
