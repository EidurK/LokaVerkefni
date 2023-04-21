package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vidmot.Project;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.IOException;
public class DropDownDesirializer extends JsonDeserializer<Project> {
    @Override
    public Project deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("DD - deserializer");
        Project dropDown = new Project();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = deserializationContext.readTree(jsonParser);
        dropDown.setFxTextField(root.get("DropDownText").asText());
        dropDown.setTaskGeymsla(objectMapper.readValue(root.get("tasks").traverse(), TaskGeymsla.class));
        System.out.println(root);
        return dropDown;
    }
}
