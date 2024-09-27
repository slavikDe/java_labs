package Vehicle;

import Passenger.Policeman;

public final class PoliceCar<T extends Policeman> extends Car{
    private final String policeCar_id;

    public PoliceCar(String model, String policeCar_id) {
        super(model, 4, 4);
        this.policeCar_id = policeCar_id;
    }

    public String getPoliceCar_id() {return policeCar_id;}
}
