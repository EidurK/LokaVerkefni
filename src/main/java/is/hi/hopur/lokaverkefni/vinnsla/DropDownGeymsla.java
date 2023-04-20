package is.hi.hopur.lokaverkefni.vinnsla;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import is.hi.hopur.lokaverkefni.vinnsla.Deserialization.DropDownGeymslaDeserializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
@JsonDeserialize(using = DropDownGeymslaDeserializer.class)
public class DropDownGeymsla {
    private ObservableList<DropDown> dropDownObservableList;
    public DropDownGeymsla(){
        dropDownObservableList = FXCollections.observableArrayList();
    }
    public ObservableList<DropDown> getDopDownGeymsla() {
        return dropDownObservableList;
    }
    public void setDropDownGeymsla(ObservableList<DropDown> od){
        dropDownObservableList = od;
    }
    public void addDropDown(DropDown d){
        dropDownObservableList.add(d);
    }
}
