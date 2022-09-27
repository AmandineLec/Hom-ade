package fil.rouge.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.repository.CrudRepository;

public final class ServiceUtils {
    
    private ServiceUtils() {}

    public static <T> T getEntity(CrudRepository<T, Integer> repository, int id) {
        

        Optional<T> optEntity = repository.findById(id);

        if (optEntity.isEmpty())
            throw new EntityNotFoundException();

        return optEntity.get();
    }
}
