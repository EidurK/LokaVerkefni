package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import java.io.IOException;
public class TaskDeserializer extends JsonDeserializer<Task> {
    public TaskDeserializer(){}
    @Override
    public Task deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
        Task task = new Task();
        JsonNode root = deserializationContext.readTree(jsonParser);
        JsonNode taskNode = root.get("DropDowns").get("tasks");
        task.setChecked(taskNode.get("isChecked").asBoolean());
        task.setLabelText(taskNode.get("text").asText());
        return task;
    }
}
