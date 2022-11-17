package fil.rouge.serializer;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fil.rouge.model.InventaireObjet;
public class InventaireObjetSerializer extends StdSerializer<InventaireObjet> {

    protected InventaireObjetSerializer(Class<InventaireObjet> t) {
        super(t);
    }

    public InventaireObjetSerializer() {
        this(null);
    }

    @Override
    public void serialize(InventaireObjet value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writePOJOField("objet", value.getObjet());
        jgen.writeNumberField("quantite", value.getQuantite());
        jgen.writePOJOField("classe", value.getObjet().getClass());
        jgen.writeEndObject();     
    }
    
}
