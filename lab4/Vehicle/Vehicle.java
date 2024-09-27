package Vehicle;
import java.util.ArrayList;
import Passenger.Passenger;
import Exeption.NoSeatsAvailableException;

public abstract class Vehicle{

    private final String model;
    private int occupied_seats = 0;
    private final int wheels;
    private final int max_seats;
    protected ArrayList<Passenger> passengers = null;

    Vehicle(String model, int wheels, int max_seats) {
        this.model = model;
        this.wheels = wheels;
        this.max_seats = max_seats;
        this.passengers = new ArrayList<>();
    }

    public void boardingPassenger(Passenger passenger) throws NoSeatsAvailableException {

        if(occupied_seats == max_seats) {
           throw new NoSeatsAvailableException("Transport has no free space for new passenger");
        }
        occupied_seats++;
        this.passengers.add(passenger);
    }

     public void dropOffPassenger(Passenger passenger) throws NoSeatsAvailableException {
        if(!passengers.contains(passenger)) {
            throw new NoSeatsAvailableException("Transport have 0 passenger. Cant drop off passenger");
        }
         occupied_seats--;
        passengers.remove(passenger);
    }

    public int getWheels(){
        return wheels;
    };

    public int getMax_seats(){
        return max_seats;
    }

    public int getNumberOfOccupiedSeats(){
        return occupied_seats;
    };

    public String getModel(){
        return this.model;
    }
}
