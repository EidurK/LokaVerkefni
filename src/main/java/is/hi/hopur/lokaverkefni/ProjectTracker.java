package is.hi.hopur.lokaverkefni;

import is.hi.hopur.lokaverkefni.*;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class ProjectTracker{

  @FXML
  private ComboBox fxComboBox;

  private ProgressBar pb;

  public ProjectTracker(){
    FXML_Lestur.lesa(this, "dropdown-view.fxml");
    pb = new ProgressBar(0);
  }
}
