module com.example.escaladeglascow {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.escaladeglascow to javafx.fxml;
    exports com.example.escaladeglascow;
}
