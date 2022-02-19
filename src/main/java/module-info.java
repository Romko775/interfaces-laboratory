module com.snu.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.snu.lab to javafx.fxml;
    exports com.snu.lab;
}
