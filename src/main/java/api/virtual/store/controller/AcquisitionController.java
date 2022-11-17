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

import api.virtual.store.dto.AcquisitionDTO;
import api.virtual.store.model.Acquisition;
import api.virtual.store.services.impl.AcquisitionServiceImpl;

@RestController
@RequestMapping("/acquisition")
public class AcquisitionController {

	@Autowired
	private AcquisitionServiceImpl acquisitionService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> newAcquisition(@RequestBody AcquisitionDTO acquisitionDTO){
		acquisitionService.newAcquisition(acquisitionDTO);
		return ResponseEntity.ok(acquisitionDTO);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<Acquisition>> allAcquisition(){
		return ResponseEntity.ok(acquisitionService.allAcquisition());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findAquisitionById(@PathVariable Long id){
		return ResponseEntity.ok(acquisitionService.findAquisitionById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody AcquisitionDTO acquisitionDTO){
		acquisitionService.update(id, acquisitionDTO);
		return ResponseEntity.ok(acquisitionDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAcquisition(@PathVariable Long id){
		acquisitionService.deleteAcquisition(id);
		return ResponseEntity.ok().build();
	}	
}
