import java.util.ArrayList;
import java.util.List;

// Базовий клас Aircraft
abstract class Aircraft {
    private final String model;
    private final int capacity;

    public Aircraft(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract void fly(); // Абстрактний метод, який реалізується у похідних класах
}

// Похідний клас Plane
class Plane extends Aircraft {
    public Plane(String model, int capacity) {
        super(model, capacity);
    }

    @Override
    public void fly() {
        System.out.println("Plane " + getModel() + " is flying with " + getCapacity() + " passengers.");
    }
}

// Похідний клас Helicopter
class Helicopter extends Aircraft {
    public Helicopter(String model, int capacity) {
        super(model, capacity);
    }

    @Override
    public void fly() {
        System.out.println("Helicopter " + getModel() + " is flying with " + getCapacity() + " passengers.");
    }
}

// Клас AirlineCompany
class AirlineCompany {
    private final List<Aircraft> aircraftList;

    public AirlineCompany() {
        aircraftList = new ArrayList<>();
    }

    // Додаємо літальний апарат (літак або гелікоптер)
    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    // Підрахунок кількості літаків
    public int countPlanes() {
        int count = 0;
        for (Aircraft aircraft : aircraftList) {
            if (aircraft instanceof Plane) {
                count++;
            }
        }
        return count;
    }

    // Підрахунок кількості гелікоптерів
    public int countHelicopters() {
        int count = 0;
        for (Aircraft aircraft : aircraftList) {
            if (aircraft instanceof Helicopter) {
                count++;
            }
        }
        return count;
    }

    // Викликати метод польоту для кожного літального апарату
    public void flyAll() {
        for (Aircraft aircraft : aircraftList) {
            aircraft.fly();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення авіакомпанії
        AirlineCompany airline = new AirlineCompany();

        // Створення об'єктів літаків і гелікоптерів
        Plane plane1 = new Plane("Boeing 737", 180);
        Plane plane2 = new Plane("Airbus A320", 160);
        Helicopter helicopter1 = new Helicopter("Black Hawk", 10);

        // Додавання літаків і гелікоптерів в авіакомпанію
        airline.addAircraft(plane1);
        airline.addAircraft(plane2);
        airline.addAircraft(helicopter1);

        // Виклик методів
        airline.flyAll();
        System.out.println("Number of planes: " + airline.countPlanes());
        System.out.println("Number of helicopters: " + airline.countHelicopters());
    }
}
