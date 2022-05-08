package com.snu.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PieChartApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 500, Color.BEIGE);

        final ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Долар США", 45.9),
                        new PieChart.Data("Євро", 42.5),
                        new PieChart.Data("Японська ієна", 1.6),
                        new PieChart.Data("Фунт стерлінгів", 9.2),
                        new PieChart.Data("Канадський долар", 0.8)
                );

        final PieChart chart = new PieChart(pieChartData);
        chart.setLayoutX(50);
        chart.setLayoutY(10);
        chart.setCursor(Cursor.CROSSHAIR);
        chart.setStyle("-fx-font:bold 14 Arial; -fx-text-fill:brown;");
        chart.setPrefSize(500, 400);
        chart.setAnimated(true);
        chart.setTitle("Розподіл валютних активів\n Ощадбанку по валюті у 2022 р.");
        chart.setTitleSide(Side.TOP);
        chart.setLegendVisible(true);
        chart.setLegendSide(Side.BOTTOM);
        chart.setClockwise(true);
        chart.setLabelsVisible(true);
        chart.setLabelLineLength(20);
        chart.setStartAngle(150);

        final Popup popup = new Popup();
        popup.setAutoHide(true);

        final Label label = new Label("");
        label.setStyle("-fx-font: bold 20 Arial;-fx-text-fill:brown");
        popup.getContent().addAll(label);
        chart.getData().forEach(data -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                label.setText(String.valueOf(data.getPieValue()) + "%");
                popup.setX(e.getScreenX());
                popup.setY(e.getScreenY());
                popup.show(primaryStage);
            });
        });

        chart.addEventHandler(MouseEvent.DRAG_DETECTED, (MouseEvent e) -> chart.setStartAngle(chart.getStartAngle() + 2));

        root.getChildren().add(chart);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Тестування GUI-компонентів: PieChart");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
