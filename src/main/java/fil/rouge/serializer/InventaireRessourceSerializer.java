package fil.rouge.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fil.rouge.model.InventaireRessource;

public class InventaireRessourceSerializer extends StdSerializer<InventaireRessource> {

    public InventaireRessourceSerializer() {
        this(null);
    }

    protected InventaireRessourceSerializer(Class<InventaireRessource> t) {
        super(t);
    }

    @Override
    public void serialize(InventaireRessource value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
                jgen.writeStartObject();
                jgen.writePOJOField("ressource", value.getRessource());
                jgen.writeNumberField("quantite", value.getQuantite());
                jgen.writeEndObject();        
    }
    
}
