package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.hi.hopur.lokaverkefni.vidmot.CheckboxingController;
import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
public class MainControllerDeserializer extends JsonDeserializer<CheckboxingController> {
    @Override
    public CheckboxingController deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        CheckboxingController controller = new CheckboxingController();
        JsonNode node = deserializationContext.readTree(jsonParser);
        ObservableList<DropDown> dropDownObservableList = FXCollections.observableArrayList();
        JsonNode nn = node.get("DropDowns");
        for (Iterator<JsonNode> iter = nn.iterator(); iter.hasNext(); ) {
            JsonNode dropdown = iter.next();
            DropDown d = new DropDown();
            d.setFxTextField(dropdown.get("DropDownText").asText());
            ObservableList<Task> taskList = FXCollections.observableArrayList();
            JsonNode tasks = dropdown.get("tasks");
            for(Iterator<JsonNode> it = tasks.iterator(); it.hasNext();){
                Task task = new Task();
                JsonNode nextTasks = it.next();
                task.setLabelText(nextTasks.get("text").asText());
                task.setChecked(nextTasks.get("isChecked").asBoolean());
                taskList.add(task);
            }
            d.getTaskGeymsla().setTaskObservableList(taskList);
            dropDownObservableList.add(d);
        }
        controller.setDropDownObservableList(dropDownObservableList);
        return controller;
    }
}
