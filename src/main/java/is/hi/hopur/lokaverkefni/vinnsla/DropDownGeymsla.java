package is.hi.hopur.lokaverkefni.vinnsla;
import is.hi.hopur.lokaverkefni.vidmot.DropDownController;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
public class DropDownGeymsla {
    private ObservableList<DropDownController> dropDownObservableList;
    public DropDownGeymsla(){
        dropDownObservableList = new SimpleListProperty<>();
    }
    public ObservableList<DropDownController> getDropDownObservableList() {
        return dropDownObservableList;
    }
    public void setDropDownObservableList(ObservableList<DropDownController> dropDownObservableList) {
        this.dropDownObservableList = dropDownObservableList;
    }
    public void addDropDown(){
        DropDownController dropDown = new DropDownController();
        dropDownObservableList.add(dropDown);
    }
}
