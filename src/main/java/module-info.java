module mobile.app.mobile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens mobile.app.mobile to javafx.fxml;
    opens mobile.app.mobile.model to javafx.base;
    exports mobile.app.mobile;
}
