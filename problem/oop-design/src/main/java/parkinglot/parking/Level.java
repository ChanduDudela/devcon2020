package parkinglot.parking;

import java.util.List;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class Level {
    private final int levelNumber;
    private final List<ParkingSpot> spots;

    public Level(int levelNumber, List<ParkingSpot> spots) {
        this.levelNumber = levelNumber;
        this.spots = spots;
    }
}
