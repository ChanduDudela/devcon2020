package parkinglot;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import parkinglot.parking.ParkingDetail;
import parkinglot.parking.ParkingSpot;
import parkinglot.vehicle.Vehicle;

public class ParkingLotController {
    private final Map<Vehicle, ParkingDetail> vehicleParkingDetailsMap = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, ParkingSpot parkingSpot) {
        vehicleParkingDetailsMap
            .put(vehicle, new ParkingDetail(vehicle, parkingSpot, Instant.now(), null));
    }

    public void onVehicleExit(Vehicle vehicle) {
        ParkingDetail parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        parkingDetails.setExitTime(Instant.now());
    }

    public BigDecimal getParkingFare(Vehicle vehicle) {
        ParkingDetail parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        return getFare(
            parkingDetails.getParking(), parkingDetails.getEntryTime(),
            parkingDetails.getExitTime());
    }

    private BigDecimal getFare(ParkingSpot parkingSpot, Instant entryTime, Instant exitTime) {
        // calculate fare based on level number (parkingSpot.levelId), spot size and time
        return null;
    }
}
