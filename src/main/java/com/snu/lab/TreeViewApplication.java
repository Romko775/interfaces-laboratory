package com.snu.lab;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TreeViewApplication extends Application  {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.BEIGE);

        Image rootimg = new Image("rootimg.png");
        final ImageView rootimv = new ImageView(rootimg);
        rootimv.setFitHeight(20);
        rootimv.setFitWidth(20);

        Image packageimg = new Image("packageimg.png");
        final ImageView packageimv = new ImageView(packageimg);
        packageimv.setFitHeight(20);
        packageimv.setFitWidth(20);

        Image packagesimg = new Image("packagesimg.png");
        final ImageView packagesimv = new ImageView(packagesimg);
        packagesimv.setFitHeight(20);
        packagesimv.setFitWidth(20);

        Image sourceimg = new Image("sourceimg.png");
        final ImageView sourceimv = new ImageView(sourceimg);
        sourceimv.setFitHeight(20);

        sourceimv.setFitWidth(20);

        TreeItem<String> rootTree = new TreeItem<>("JavaFXApplicationTreeView");
        rootTree.setExpanded(true);
        rootTree.setGraphic(rootimv);

        TreeItem<String> itemPS = new TreeItem<>("Пакети вихідних файлів");
        itemPS.setExpanded(true);
        itemPS.setGraphic(packagesimv);

        TreeItem<String> itemP = new TreeItem<>("javafxapplication");
        itemP.setExpanded(true);
        itemP.setGraphic(packageimv);

        final TreeItem<String> itemS = new TreeItem<>("JavaFXApplication.java");

        itemS.setGraphic(sourceimv);
        itemP.getChildren().addAll(itemS);
        itemPS.getChildren().addAll(itemP);
        rootTree.getChildren().addAll(itemPS);

        TreeView<String> treeView = new TreeView<>(rootTree);
        treeView.setLayoutX(10);
        treeView.setLayoutY(10);
        treeView.setCursor(Cursor.CLOSED_HAND);
        treeView.setStyle("-fx-border-width:3pt;-fx-border-color:#f0e68c;-fx-font:12pt Georgia;");
        treeView.setPrefSize(300, 200);
        treeView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends TreeItem<String>> ov, TreeItem<String>
                        old_val, TreeItem<String> new_val) -> {
                    if (new_val == itemS) {
                        System.out.println("Редагування вихідного коду");
                    }
                });

        root.getChildren().add(treeView);

        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: TreeView");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
