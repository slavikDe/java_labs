package Vehicle;

import Passenger.Passenger;

public final class Bus<T extends Passenger> extends Vehicle {
    private final String route;

    Bus(String model, String route) {
        super(model, 8, 12);
        this.route = route;
    }

    public String getRoute() {return route;}
}
