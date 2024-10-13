import java.util.ArrayList;
import java.util.List;

// Клас Карликова планета, що реалізує Planet
class DwarfPlanet implements Planet {
    private String name;
    private final List<String> characteristics = new ArrayList<>();
    private final List<String> photos = new ArrayList<>();

    public void addPlanet(String name) {
        this.name = name;
        System.out.println("Карликова планета додана: " + name);
    }

    public void announceDiscovery() {
        System.out.println("Відкрито карликову планету: " + name);
    }

    public void setOrUpdateCharacteristics(String characteristic, String value) {
        characteristics.add(characteristic + ": " + value);
    }

    public double calculateRotationPeriod(double distanceFromSun) {
        return distanceFromSun * 0.9; // Спрощена формула
    }

    public void buildModel() {
        System.out.println("Побудовано модель для карликової планети: " + name);
    }

    public void updateModel() {
        System.out.println("Оновлено модель для карликової планети: " + name);
    }

    public void requestAdditionalResearch() {
        System.out.println("Отримано запит на додаткові дослідження для карликової планети: " + name);
    }

    public void purchaseCustomName(String customName) {
        System.out.println("Індивідуальна назва для карликової планети " + name + ": " + customName);
    }

    public void addPhoto(String photo) {
        photos.add(photo);
        System.out.println("Фото додано для карликової планети " + name);
    }

    public void printReport() {
        System.out.println("Звіт про планету " + name);
        System.out.println("Характеристики: " + characteristics);
        System.out.println("Фотографії: " + photos);
    }

    public boolean hasCharacteristic(String characteristic, String value) {
        return characteristics.contains(characteristic + ": " + value);
    }

    // Спеціалізований метод для Карликових планет
    public void measureSurfaceGravity() {
        System.out.println("Виміряно поверхневу гравітацію для " + name);
    }
}