import java.util.ArrayList;
import java.util.List;

// Клас Крижаний гігант, що реалізує Planet
class IceGiant implements Planet {
    private String name;
    private final List<String> characteristics = new ArrayList<>();
    private final List<String> photos = new ArrayList<>();

    public void addPlanet(String name) {
        this.name = name;
        System.out.println("Крижаний гігант додано: " + name);
    }

    public void announceDiscovery() {
        System.out.println("Відкрито крижаний гігант: " + name);
    }

    public void setOrUpdateCharacteristics(String characteristic, String value) {
        characteristics.add(characteristic + ": " + value);
    }

    public double calculateRotationPeriod(double distanceFromSun) {
        return distanceFromSun * 0.7; // Спрощена формула
    }

    public void buildModel() {
        System.out.println("Побудовано модель для крижаного гіганта: " + name);
    }

    public void updateModel() {
        System.out.println("Оновлено модель для крижаного гіганта: " + name);
    }

    public void requestAdditionalResearch() {
        System.out.println("Отримано запит на додаткові дослідження для крижаного гіганта: " + name);
    }

    public void purchaseCustomName(String customName) {
        System.out.println("Індивідуальна назва для крижаного гіганта " + name + ": " + customName);
    }

    public void addPhoto(String photo) {
        photos.add(photo);
        System.out.println("Фото додано для крижаного гіганта" + name);
    }

    public void printReport() {
        System.out.println("Звіт про планету " + name);
        System.out.println("Характеристики: " + characteristics);
        System.out.println("Фотографії: " + photos);
    }

    public boolean hasCharacteristic(String characteristic, String value) {
        return characteristics.contains(characteristic + ": " + value);
    }

    // Спеціалізований метод для Крижаних гігантів
    public void analyzeIceComposition() {
        System.out.println("Аналіз льодової композиції для крижаного гіганта " + name);
    }
}