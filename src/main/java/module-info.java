module com.nikmax.modinstaller {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires zip4j;
    requires commons.io;

    opens com.nikmax.modinstaller to javafx.fxml;
    exports com.nikmax.modinstaller;
}