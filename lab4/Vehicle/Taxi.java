package Vehicle;

import Passenger.Passenger;

public final class Taxi<T extends Passenger> extends Car {
    private final String taxi_number;

    public Taxi(String model, String taxi_number) {
        super(model, 4, 3);
        this.taxi_number = taxi_number;
    }

    public String getTaxi_number() {return this.taxi_number;}
}
