package fil.rouge.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fil.rouge.model.Objet;

public class RecetteSerializer extends StdSerializer<Objet>  {

    
    public RecetteSerializer() {
        this(null);
    }

    protected RecetteSerializer(Class<Objet> t) {
        super(t);
    }

    @Override
    public void serialize(Objet value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("nom", value.getNom());
        jgen.writeStringField("img", value.getImg());
        jgen.writePOJOField("recettes", value.getRecette());
        jgen.writePOJOField("classe", value.getClass());
        jgen.writeEndObject();
    }
    
}
