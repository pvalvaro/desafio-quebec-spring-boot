package api.virtual.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.virtual.store.model.Acquisition;

@Repository
public interface AcquisitionRepository extends CrudRepository<Acquisition, Long> {
}
