package fil.rouge.serializer;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import fil.rouge.dao.RecetteRepository;
import fil.rouge.model.Objet;
import fil.rouge.model.Recette;

public class RecetteSerializer extends StdSerializer<Objet>  {

    @Autowired
    RecetteRepository recetterepository; 
    
    public RecetteSerializer() {
        this(null);
    }

    protected RecetteSerializer(Class<Objet> t) {
        super(t);
    }

    @Override
    public void serialize(Objet value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("nom", value.getNom());
        jgen.writePOJOField("recettes", value.getRecette());
        jgen.writeEndObject();
    }
    
}
