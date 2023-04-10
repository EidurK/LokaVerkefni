module is.hi.hopur.lokaverkefni {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.hi.hopur.lokaverkefni to javafx.fxml;
    exports is.hi.hopur.lokaverkefni;
}