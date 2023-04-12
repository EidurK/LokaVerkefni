package is.hi.hopur.lokaverkefni.vinnsla;

import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class DropDownGeymsla {
    private ObservableList<DropDown> dropDownObservableList;
    public DropDownGeymsla(){
        dropDownObservableList = new SimpleListProperty<>();
    }

    public ObservableList<DropDown> getDropDownObservableList() {
        return dropDownObservableList;
    }
    public void addDropDown(){
        DropDown dropDown = new DropDown();
        dropDownObservableList.add(dropDown);
    }
}
