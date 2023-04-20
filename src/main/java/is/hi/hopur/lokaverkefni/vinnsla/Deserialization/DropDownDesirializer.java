package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.IOException;
public class DropDownDesirializer extends JsonDeserializer<DropDown> {
    @Override
    public DropDown deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("DD - deserializer");
        DropDown dropDown = new DropDown();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = deserializationContext.readTree(jsonParser);
        dropDown.setFxTextField(root.get("DropDownText").asText());
        dropDown.setTaskGeymsla(objectMapper.readValue(root.get("tasks").traverse(), TaskGeymsla.class));
        System.out.println(root);
        return dropDown;
    }
}
