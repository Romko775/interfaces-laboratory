package com.snu.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TableViewApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, Color.BEIGE);

        Label label = new Label("ТОП 5 готелів Туреччини");
        label.setLayoutX(10);
        label.setLayoutY(10);
        label.setPrefSize(500, 30);

        label.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:#000066;-fxbackground-color:lightgrey;");
        label.setAlignment(Pos.CENTER);

        ObservableList<Hotel> hotels = FXCollections.observableArrayList(
                new Hotel("Amara Dolce Vita", "Кемер", "HV1", 4.5),
                new Hotel("Club Boran Mare Beach", "Кемер", "HV1", 4.7),
                new Hotel("Delphin Botanik World of Paradise", "Аланія", "5*", 4.4),
                new Hotel("Kamelya World Hotel Fulya", "Сіде", "5*", 4.8),
                new Hotel("Delphin Deluxe Resort", "Алания", "5*", 4.7)
        );

        TableView<Hotel> table = new TableView<>();
        table.setLayoutX(10);
        table.setLayoutY(50);
        table.setTableMenuButtonVisible(true);
        table.setCursor(Cursor.TEXT);
        table.setTooltip(new Tooltip("Популярні готелі Туреччини"));
        table.setStyle("-fx-font: 12pt Arial;");
        table.setPrefWidth(500);
        table.setPrefHeight(200);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn nameCol = new TableColumn("Готель");
        nameCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("name"));
        nameCol.setPrefWidth(250);
        nameCol.setResizable(false);
        nameCol.setSortable(true);

        TableColumn resortCol = new TableColumn("Курорт");
        resortCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("resort"));

        TableColumn categoryCol = new TableColumn("Категорія");
        categoryCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("category"));

        TableColumn rateCol = new TableColumn("Рейтинг");
        rateCol.setCellValueFactory(new PropertyValueFactory<Hotel, String>("rate"));

        table.setItems(hotels);
        table.getColumns().addAll(nameCol, resortCol, categoryCol, rateCol);

        root.getChildren().add(label);
        root.getChildren().add(table);

        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: TableView");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

