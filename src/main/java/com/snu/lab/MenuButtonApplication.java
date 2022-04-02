package com.snu.lab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuButtonApplication extends Application {
    private final String MenuItemFontStyle = "-fx-font:bold italic 12pt Times;";

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.LIGHTGREEN);

        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: MenuButton");

        MenuButton btn = createMenuBtn();
        btn.getItems().addAll(createMenuItemCut(), createMenuItemCopy(), createMenuItemPaste());

        root.getChildren().add(btn);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private MenuButton createMenuBtn() {
        MenuButton _btn = new MenuButton("Правка");
        _btn.setLayoutX(20);
        _btn.setLayoutY(20);
        _btn.setBlendMode(BlendMode.HARD_LIGHT);
        _btn.setCursor(Cursor.CLOSED_HAND);

        DropShadow effect=new DropShadow();
        effect.setOffsetX(8);
        effect.setOffsetY(8);

        _btn.setEffect(effect);
        _btn.setPrefSize(200,80);
        _btn.setTooltip(new Tooltip("Це кнопка контекстного меню"));

        Image img;
        ImageView imv;

        try {
            img = new Image("image.jpeg");
            imv = new ImageView(img);
            imv.setFitHeight(50);
            imv.setFitWidth(50);
            _btn.setGraphic(imv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        _btn.setStyle("-fx-font: bold italic 14pt Georgia;");
        _btn.setAlignment(Pos.CENTER);
        _btn.setContentDisplay(ContentDisplay.LEFT);
        _btn.setTextAlignment(TextAlignment.CENTER);
        _btn.setGraphicTextGap(10);
        _btn.setWrapText(true);
        _btn.setPopupSide(Side.RIGHT);

        return _btn;
    }

    private MenuItem createMenuItemCut() {
        MenuItem _menuItemCut = new MenuItem("Вирізати");
        _menuItemCut.setStyle(MenuItemFontStyle);
        _menuItemCut.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
        _menuItemCut.setOnAction(e -> System.out.println("Вирізаю"));
        return _menuItemCut;
    }

    private MenuItem createMenuItemCopy() {
        MenuItem _menuItemCopy = new MenuItem("Копіювати");
        _menuItemCopy.setStyle(MenuItemFontStyle);
        _menuItemCopy.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        _menuItemCopy.setOnAction(e1 -> System.out.println("Копіюю"));
        return _menuItemCopy;
    }

    private MenuItem createMenuItemPaste() {
        MenuItem _menuItemPaste = new MenuItem("Вставити");
        _menuItemPaste.setStyle(MenuItemFontStyle);
        _menuItemPaste.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
        _menuItemPaste.setOnAction(e2 -> System.out.println("Вставляю"));
        return _menuItemPaste;
    }

}
