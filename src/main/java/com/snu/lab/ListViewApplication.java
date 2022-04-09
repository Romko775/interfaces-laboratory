package com.snu.lab;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ListViewApplication extends Application {
    private final String listStyles = "-fx-border-width:3pt;-fx-border-color:navy;-fx-font:bold 12pt Georgia;";
    final DropShadow effect = new DropShadow();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400, Color.BEIGE);
        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: ListView");

        effect.setOffsetX(10);
        effect.setOffsetY(10);

        ObservableList<String> categories = FXCollections.observableArrayList("Побутова техніка", "Посуд", "Госптовари");
        ListView<String> listViewC = createListView(categories, new int[]{10, 10}, new int[]{470, 170}, Cursor.OPEN_HAND, Orientation.HORIZONTAL);
        listViewC.setTooltip(new Tooltip("Виберіть категорію товару"));
        listViewC.setCellFactory((ListView<String> p) -> {
            Button btn = new Button();
            btn.setEffect(effect);
            btn.setStyle("-fx-background-color:#66ccff;");
            btn.setPrefSize(130, 50);
            btn.setCursor(Cursor.NONE);
            btn.setWrapText(true);

            final ListCell<String> cell = new ListCell<String>(){
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        btn.setText(item);
                        this.setGraphic(btn);
                    }
                }
            };
            return cell;
        });

        ListView<String> listViewH = createCollectionsListView(FXCollections.observableArrayList("Вентилятор", "М’ясорубка", "Насос"));
        ListView<String> listViewU = createCollectionsListView(FXCollections.observableArrayList("Чайник", "Каструля", "Пательня"));
        ListView<String> listViewW = createCollectionsListView(FXCollections.observableArrayList("Шланг", "Лопата", "Ваги"));

        listViewC
                .getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if(new_val.equals("Побутова техніка")){
                        listViewH.setVisible(true);
                        listViewU.setVisible(false);
                        listViewW.setVisible(false);
                    }
                    if(new_val.equals("Посуд")){
                        listViewU.setVisible(true);
                        listViewH.setVisible(false);
                        listViewW.setVisible(false);
                    }
                    if(new_val.equals("Госптовари")){
                        listViewW.setVisible(true);
                        listViewH.setVisible(false);
                        listViewU.setVisible(false);
                    }
                });

        root.getChildren().add(listViewC);
        root.getChildren().add(listViewH);
        root.getChildren().add(listViewU);
        root.getChildren().add(listViewW);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ListView<String> createListView(
            ObservableList<String> data,
            int[] layout,
            int[] size,
            Cursor cursor,
            Orientation orientation
    ) {
        ListView<String> _listView = new ListView<>(data);
        _listView.setLayoutX(layout[0]);
        _listView.setLayoutY(layout[1]);
        _listView.setPrefSize(size[0], size[1]);
        _listView.setCursor(cursor);

        _listView.setEffect(effect);
        _listView.setStyle(listStyles);
        _listView.setOrientation(orientation);
        return _listView;
    }

    private ListView<String> createCollectionsListView(ObservableList<String> data) {
        ListView<String> _listView = createListView(data, new int[]{10, 220}, new int[]{200, 150}, Cursor.CROSSHAIR, Orientation.VERTICAL);
        _listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        _listView.setVisible(false);
        return _listView;
    }
}
