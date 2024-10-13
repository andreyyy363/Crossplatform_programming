public interface Planet {
    // Додати планету
    void addPlanet(String name);

    // Повідомити про відкриття
    void announceDiscovery();

    // Встановити або оновити характеристики
    void setOrUpdateCharacteristics(String characteristic, String value);

    // Розрахувати період обертання
    double calculateRotationPeriod(double distanceFromSun);

    // Побудувати модель
    void buildModel();

    // Оновити модель
    void updateModel();

    // Відправити запит про додаткові дослідження
    void requestAdditionalResearch();

    // Придбати індивідуальну назву
    void purchaseCustomName(String customName);

    // Додати фото
    void addPhoto(String photo);

    // Надрукувати звіт
    void printReport();

    // Перевірка наявності характеристики
    boolean hasCharacteristic(String characteristic, String value);
}