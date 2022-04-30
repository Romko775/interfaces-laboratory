package com.snu.lab;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuBarApplication extends Application {
    private final String menuItemStyle = "-fx-text-fill:navy;-fx-font:bold italic 14pt Georgia;";
    private final String menuItemStyle2 = "-fx-text-fill: navy;-fx-font:bold italic 14pt Georgia;";
    private final String radioStyle = "-fx-text-fill:navy;-fx-font:bold italic 12pt Georgia;";

    Menu menuFile = new Menu("Файл");
    Menu menuEdit = new Menu("Правка");
    Menu menuView = new Menu("Вид");

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 450, 300, Color.BEIGE);

        MenuBar menuBar = new MenuBar();
        menuBar.setLayoutX(10);
        menuBar.setLayoutY(10);
        menuBar.setBlendMode(BlendMode.HARD_LIGHT);
        menuBar.setCursor(Cursor.CLOSED_HAND);

        DropShadow effect = new DropShadow();
        effect.setOffsetX(5);
        effect.setOffsetY(5);

        menuBar.setEffect(effect);
        menuBar.setStyle("-fx-base:skyblue;-fx-border-width:4pt;-fx-border-color:navy;-fx-font:bold 16pt Georgia;");
        menuBar.setPrefSize(350, 50);

        createMenuFile();
        createMenuEdit();
        createMenuView();

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        root.getChildren().add(menuBar);

        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: MenuBar, Menu");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createMenuFile() {
        MenuItem menuItemP = new MenuItem("Друк");
        menuItemP.setStyle(menuItemStyle2);
        menuItemP.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
        menuItemP.setOnAction((ActionEvent e) -> System.out.println("Триває друк..."));

        SeparatorMenuItem sep = new SeparatorMenuItem();

        RadioMenuItem radioItemY = new RadioMenuItem("З номерами сторінок");
        radioItemY.setStyle(radioStyle);

        ToggleGroup tgroup = new ToggleGroup();

        radioItemY.setToggleGroup(tgroup);
        radioItemY.setSelected(true);

        RadioMenuItem radioItemN = new RadioMenuItem("Без номерів сторінок");
        radioItemN.setStyle(radioStyle);
        radioItemN.setToggleGroup(tgroup);

        CheckMenuItem checkMenuItem = new CheckMenuItem("Покращена якість");
        checkMenuItem.setSelected(true);
        checkMenuItem.setStyle(menuItemStyle);

        menuFile.getItems().addAll(menuItemP, radioItemY, radioItemN, sep, checkMenuItem);
    }

    private void createMenuEdit() {
        MenuItem menuItemCut = new MenuItem("Вирізати");
        menuItemCut.setStyle(menuItemStyle);

        MenuItem menuItemCopy = new MenuItem("Копіювати");
        menuItemCopy.setStyle(menuItemStyle);

        MenuItem menuItemPaste = new MenuItem("Вставити");
        menuItemPaste.setStyle(menuItemStyle);

        menuEdit.getItems().addAll(menuItemCut, menuItemCopy, menuItemPaste);
    }

    private void createMenuView() {
        MenuItem menuItemS = new MenuItem("Масштаб");
        menuItemS.setStyle(menuItemStyle2);
        menuView.getItems().addAll(menuItemS);
    }
}
