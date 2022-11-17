package api.virtual.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.virtual.store.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
