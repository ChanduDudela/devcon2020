package parkinglot.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ParkingLot {
    public ParkingLot() {
        Level l1 = Level.builder()
            .levelNumber(1)
            .spots(new ArrayList<>())
            .build();
        ParkingSpot p1 =
            ParkingSpot.builder().isOccupied(false).id(1).levelId(1).parkingSpotSize(ParkingSpotSize.SMALL)
                .build();
        ParkingSpot p2 =
            ParkingSpot.builder().isOccupied(false).id(2).levelId(1).parkingSpotSize(ParkingSpotSize.SMALL)
                .build();

        Level l2 = Level.builder()
            .levelNumber(2)
            .spots(Arrays.asList(p1, p2))
            .build();

        List<Level> levels = new ArrayList<>();
        levels.add(l1);
        levels.add(l2);
    }

    private int id;
    private List<Level> levels;
    private String parkingName;
    private String address;

    public ParkingLot(List<Level> levels, String parkingName, String address) {
        this.levels = levels;
        this.parkingName = parkingName;
        this.address = address;
    }
}
