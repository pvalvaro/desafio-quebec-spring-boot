package api.virtual.store.services;

import api.virtual.store.model.Client;

public interface ClientService {
	
	Iterable<Client> allClient();
	Client findClientById(Long id);
	void newClient(Client client);
	void update(Long id, Client client);
	void deleteClient(Long id);
}
