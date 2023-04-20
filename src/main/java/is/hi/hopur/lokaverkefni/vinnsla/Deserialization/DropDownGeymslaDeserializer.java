package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vidmot.DropDown;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;
import is.hi.hopur.lokaverkefni.vinnsla.TaskGeymsla;
import java.io.DataInput;
import java.io.IOException;
import java.util.Iterator;
public class DropDownGeymslaDeserializer extends JsonDeserializer<DropDownGeymsla> {
    @Override
    public DropDownGeymsla deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("DDG - deserializer");
        JsonNode node = deserializationContext.readTree(jsonParser);
        DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
        JsonNode dropDownNode = node.get("DropDowns");
        for (JsonNode dropdown : dropDownNode) {
            ObjectMapper objectMapper = new ObjectMapper();
            DropDown dropDown = objectMapper.readValue(dropdown.traverse(), DropDown.class);
            dropDownGeymsla.addDropDown(dropDown);
        }
        return dropDownGeymsla;
    }
}
