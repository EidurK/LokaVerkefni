package is.hi.hopur.lokaverkefni.vinnsla.Deserialization;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import is.hi.hopur.lokaverkefni.vidmot.Task;
import java.io.IOException;
public class TaskSerializer extends JsonSerializer<Task> {
    public TaskSerializer(){}
    @Override
    public void serialize(Task task, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeBooleanField("isChecked", task.getFxCheckBox().isSelected());
        jsonGenerator.writeStringField("taskName", task.getFxCheckBox().textProperty().getValue());
        jsonGenerator.writeEndObject();
    }
}