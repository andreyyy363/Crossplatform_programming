/*
Варіант 19.
Планета.
Можливості: додати планету; повідомити про відкриття;
додати/змінити характеристики; розрахувати період обертання; побудувати
модель планети; змінити модель планети; замовити додаткові дослідження;
купити індивідуальну назву; додати фотографії; надрукувати звіт про планету;
вибрати планети за параметром.
Додати спеціалізовані методи для Газових гігантів, Крижаних гігантів, Карликових планет.
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Метод для вибору планет за заданим параметром
    public static List<Planet> selectPlanetsByCharacteristic(List<Planet> planets, String characteristic, String value) {
        List<Planet> selectedPlanets = new ArrayList<>();
        for (Planet planet : planets) {
            if (planet.hasCharacteristic(characteristic, value)) {
                selectedPlanets.add(planet);
            }
        }
        return selectedPlanets;
    }

    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();

        // Створення газового гіганта та виклик методів
        GasGiant jupiter = new GasGiant();
        jupiter.addPlanet("Юпітер");
        jupiter.setOrUpdateCharacteristics("Маса", "1.898 × 10^27 кг");
        jupiter.announceDiscovery();
        System.out.println("Період обертання: " + jupiter.calculateRotationPeriod(778.5) + " годин");
        jupiter.buildModel();
        jupiter.updateModel();
        jupiter.requestAdditionalResearch();
        jupiter.purchaseCustomName("Король Планет");
        jupiter.addPhoto("photo1.jpg");
        jupiter.measureAtmosphericPressure();
        jupiter.printReport();
        planets.add(jupiter);

        System.out.println("\n");

        // Створення крижаного гіганта та виклик методів
        IceGiant neptune = new IceGiant();
        neptune.addPlanet("Нептун");
        neptune.setOrUpdateCharacteristics("Температура", "-214°C");
        neptune.announceDiscovery();
        System.out.println("Період обертання: " + neptune.calculateRotationPeriod(4495.1) + " годин");
        neptune.buildModel();
        neptune.updateModel();
        neptune.requestAdditionalResearch();
        neptune.purchaseCustomName("Лідяний Титан");
        neptune.addPhoto("photo2.jpg");
        neptune.analyzeIceComposition();
        neptune.printReport();
        planets.add(neptune);

        System.out.println("\n");

        // Створення карликової планети та виклик методів
        DwarfPlanet pluto = new DwarfPlanet();
        pluto.addPlanet("Плутон");
        pluto.setOrUpdateCharacteristics("Діаметр", "2376 км");
        pluto.announceDiscovery();
        System.out.println("Період обертання: " + pluto.calculateRotationPeriod(5906.4) + " годин");
        pluto.buildModel();
        pluto.updateModel();
        pluto.requestAdditionalResearch();
        pluto.purchaseCustomName("Малий Мандрівник");
        pluto.addPhoto("photo3.jpg");
        pluto.measureSurfaceGravity();
        pluto.printReport();
        planets.add(pluto);

        // Вибираємо планети за типом
        List<Planet> gasGiants = selectPlanetsByCharacteristic(planets, "Діаметр", "2376 км");
        System.out.println("\nВибрані планети:");
        for (Planet planet : gasGiants) {
            planet.printReport();
        }
    }
}
