package api.virtual.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.virtual.store.model.Client;
import api.virtual.store.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired 
	private ClientService clientService;
	
	@PostMapping("/add")
	public ResponseEntity<Client> newClient(@RequestBody Client client){
		clientService.newClient(client);
		return ResponseEntity.ok(client);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> allClient(){
		return ResponseEntity.ok(clientService.allClient());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findClientById(@PathVariable Long id){
		return ResponseEntity.ok(clientService.findClientById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Client client){
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id){
		clientService.deleteClient(id);
		return ResponseEntity.ok().build();
	}
}
