module is.hi.hopur.lokaverkefni.vidmot{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    exports is.hi.hopur.lokaverkefni.vidmot;
    exports is.hi.hopur.lokaverkefni.vinnsla;
    opens is.hi.hopur.lokaverkefni to javafx.fxml;
}