package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.IOException;
import java.util.Iterator;
public class TaskGeymslaDeserializer extends JsonDeserializer<TaskGeymsla> {
    public TaskGeymslaDeserializer(){}
    @Override
    public TaskGeymsla deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
        System.out.println("TG - deserializer");
        TaskGeymsla geymsla = new TaskGeymsla();
        JsonNode root = deserializationContext.readTree(jsonParser);
        for (JsonNode jsonNode : root) {
            ObjectMapper objectMapper = new ObjectMapper();
            Task task = objectMapper.readValue(jsonNode.traverse(), Task.class);
            geymsla.addTask(task);
        }
        return geymsla;
    }
}
