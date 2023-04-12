package is.hi.hopur.lokaverkefni.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CheckboxingApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CheckboxingApplication.class.getResource("MainApplication-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 460, 480);
    stage.setTitle("Tasks");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
