package Vehicle;

import Passenger.Firefighter;

public final class FireCar<T extends Firefighter> extends Car {
    private final int water_capacity;

    FireCar(int max_seats, String model, int wheels, int water_capacity) {
        super(model, 6, 8);
        this.water_capacity = water_capacity;
    }

    public int getWater_capacity() {return this.water_capacity;}
}
