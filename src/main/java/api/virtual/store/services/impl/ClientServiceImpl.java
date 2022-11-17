package api.virtual.store.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.virtual.store.model.Address;
import api.virtual.store.model.Client;
import api.virtual.store.repositories.AddressRepository;
import api.virtual.store.repositories.ClientRepository;
import api.virtual.store.services.ClientService;
import api.virtual.store.services.PostalService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AddressRepository addressRepository ;
	
	@Autowired
	PostalService postalService;
	  
	@Override
	public void newClient(Client client) {
		saveClientWithAddress(client);
	}

	@Override
	public Iterable<Client> allClient(){
		return clientRepository.findAll();
	}
	
	@Override
	public Client findClientById(Long id){
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	
	@Override
	public void update(Long id, Client client){
		Optional<Client> clientbd = clientRepository.findById(id);
		if(clientbd.isPresent()) {
			saveClientWithAddress(client);
		}
	}
	
	@Override
	public void deleteClient(Long id){
		clientRepository.deleteById(id);
	}
	

	private void saveClientWithAddress(Client client) {
		String zipcode = client.getAddress().getCep();
		Address address = addressRepository.findById(zipcode).orElseGet(()-> {
			Address newAddress = postalService.getZipCode(zipcode);
			addressRepository.save(newAddress);
			return newAddress;
		});
		
		client.setAddress(address);
		clientRepository.save(client);
	}
}
