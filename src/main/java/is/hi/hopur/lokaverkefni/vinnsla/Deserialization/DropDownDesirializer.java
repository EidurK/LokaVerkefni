package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.IOException;
public class DropDownDesirializer extends JsonDeserializer<DropDown> {
    @Override
    public DropDown deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        DropDown dropDown = new DropDown();
        TaskGeymsla taskGeymsla = new TaskGeymsla();
        JsonNode root = deserializationContext.readTree(jsonParser);
        dropDown.setFxTextField(root.get("DropDownText").asText());
        for(JsonNode task: root.get("tasks")) {
            taskGeymsla.addItem(deserializationContext.readTreeAsValue(task, Task.class));
        }
        dropDown.setTaskGeymsla(taskGeymsla);
            return dropDown;
    }
}
