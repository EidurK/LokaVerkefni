package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hopur.lokaverkefni.vidmot.Project;
import is.hi.hopur.lokaverkefni.vinnsla.DropDownGeymsla;

import java.io.IOException;

public class DropDownGeymslaDeserializer extends JsonDeserializer<DropDownGeymsla> {
    @Override
    public DropDownGeymsla deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        System.out.println("DDG - deserializer");
        JsonNode node = deserializationContext.readTree(jsonParser);
        DropDownGeymsla dropDownGeymsla = new DropDownGeymsla();
        JsonNode dropDownNode = node.get("DropDowns");
        for (JsonNode dropdown : dropDownNode) {
            ObjectMapper objectMapper = new ObjectMapper();
            Project dropDown = objectMapper.readValue(dropdown.traverse(), Project.class);
            dropDownGeymsla.addDropDown(dropDown);
        }
        return dropDownGeymsla;
    }
}
