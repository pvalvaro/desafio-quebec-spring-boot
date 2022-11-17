package api.virtual.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.virtual.store.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	boolean existsByCpf(String cpf);
}
