import java.util.ArrayList;
import java.util.List;
import Vehicle.Vehicle;

public class Road {
    private final List<Vehicle> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int totalHumans = 0;
        for (Vehicle vehicle : carsInRoad) {
            totalHumans += vehicle.getNumberOfOccupiedSeats();
        }
        return totalHumans;
    }

    public <T extends Vehicle> void addCarToRoad(T vehicle) {
        carsInRoad.add(vehicle);
    }
}
