import java.util.ArrayList;
import java.util.List;

// Клас Газовий гігант, що реалізує Planet
class GasGiant implements Planet {
    private String name;
    private final List<String> characteristics = new ArrayList<>();
    private final List<String> photos = new ArrayList<>();
    private String customName;

    public void addPlanet(String name) {
        this.name = name;
        System.out.println("Газовий гігант додано: " + name);
    }

    public void announceDiscovery() {
        System.out.println("Відкрито газовий гігант: " + name);
    }

    public void setOrUpdateCharacteristics(String characteristic, String value) {
        characteristics.add(characteristic + ": " + value);
    }

    public double calculateRotationPeriod(double distanceFromSun) {
        return distanceFromSun * 0.5;
    }

    public void buildModel() {
        System.out.println("Побудовано модель для газового гіганта: " + name);
    }

    public void updateModel() {
        System.out.println("Оновлено модель для газового гіганта: " + name);
    }

    public void requestAdditionalResearch() {
        System.out.println("Отримано запит на додаткові дослідження для: " + name);
    }

    public void purchaseCustomName(String customName) {
        this.customName = customName;
        System.out.println("Індивідуальна назва для газового гіганта " + name + ": " + customName);
    }

    public void addPhoto(String photo) {
        photos.add(photo);
        System.out.println("Фото додано для газового гіганта " + name);
    }

    public void printReport() {
        System.out.println("Звіт про планету " + name);
        System.out.println("Характеристики: " + characteristics);
        System.out.println("Індивідуальна назва: " + customName);
        System.out.println("Фотографії: " + photos);
    }

    public boolean hasCharacteristic(String characteristic, String value) {
        return characteristics.contains(characteristic + ": " + value);
    }

    // Спеціалізований метод для Газових гігантів
    public void measureAtmosphericPressure() {
        System.out.println("Виміряно атмосферний тиск для газового гіганта " + name);
    }
}