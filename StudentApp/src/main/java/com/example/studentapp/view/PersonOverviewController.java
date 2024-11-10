package com.example.studentapp.view;

import com.example.studentapp.MainApp;
import com.example.studentapp.model.Person;
import com.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label groupCodeLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label specialtyLabel;
    @FXML
    private Label courseLabel;
    @FXML
    private Label gradeLabel;

    private MainApp mainApp;


    public PersonOverviewController() {
    }

    // Ініціалізація класу-контролера. Цей метод викликається автоматично
    @FXML
    private void initialize() {
        // Ініціалізація таблиці адресатів із двома стовпцями.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        // Очищення додаткової інформації про студента.
        showPersonDetails(null);
        // Слухаємо зміни вибору і при зміні відображаємо додаткову інформацію про студента.
        personTable.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> showPersonDetails(newValue));
    }

    // Викликається головним класом, щоб забезпечити посилання на себе
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Додавання до таблиці даних із спостережуваного списку
        personTable.setItems(mainApp.getPersonData());
    }

    // Відображення додаткової інформації про студента.
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Заповнюємо позначки інформацією з об'єкта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            specialtyLabel.setText(person.getSpecialty());
            courseLabel.setText(String.valueOf(person.getCourse()));
            gradeLabel.setText(String.valueOf(person.getGrade()));
        } else {
            // Якщо Person = null, то забираємо весь текст.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");
            specialtyLabel.setText("");
            courseLabel.setText("");
            gradeLabel.setText("");
        }
    }

    // Викликається, коли користувач натискає на кнопку New Person
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    // Викликається, коли користувач натискає на кнопку Edit
    @FXML
    private void handleEditPerson() {
        Person
                selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {
            // Нічого не вибрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    // Викликається, коли користувач натискає на кнопку Delete
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // Виведення повторного підтвердження видалення запису
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Delete Person");
            alert.setContentText("Are you sure you want to delete the selected person?");

            // Очікування відповіді користувача
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                personTable.getItems().remove(selectedIndex);
            }
        } else {
            // Нічого не вибрано
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
}