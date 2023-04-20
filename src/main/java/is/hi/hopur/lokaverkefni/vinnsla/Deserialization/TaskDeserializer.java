package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import java.io.IOException;
public class TaskDeserializer extends JsonDeserializer<Task> {
    @Override
    public Task deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("T - Deserializer");
        Task task = new Task();
        JsonNode root = deserializationContext.readTree(jsonParser);
        task.setChecked(root.get("isChecked").asBoolean());
        task.setLabelText(root.get("text").asText());
        return task;
    }
}
