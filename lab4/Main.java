import Exeption.NoSeatsAvailableException;
import Passenger.*;
import Vehicle.FireCar;
import Vehicle.PoliceCar;
import Vehicle.Taxi;

public class Main {
    public static void main(String[] args) {

        Policeman policeman = new Policeman("na", "la", 12);
        Taxi<Passenger> taxi = new Taxi<Passenger>("model",  "nu,se");
        Taxi<Passenger> taxi2 = new Taxi<Passenger>("model2",  "nu,se1");
        Passenger passenger = new Passenger("fi", "as", 21);

        try{
            taxi2.boardingPassenger(passenger);
            taxi2.boardingPassenger(new Passenger("fi", "as", 21));

            taxi2.boardingPassenger(new Passenger("fi", "as", 21));
            taxi.boardingPassenger(new Passenger("fi", "as", 21));
            taxi2.dropOffPassenger(passenger);
        }catch (Exception e){
            System.out.println("error");
        }

        Road road = new Road();
        road.addCarToRoad(taxi);
        road.addCarToRoad(taxi2);

        System.out.println(road.getCountOfHumans());
    }
}
