package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import is.hi.hopur.lokaverkefni.vidmot.DropDownController;
import java.io.IOException;
public class DropDownSerializer extends JsonDeserializer<DropDownController>{
  @Override
  public DropDownController deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
    DropDownController dc = new DropDownController();
    return null;
  }
}
