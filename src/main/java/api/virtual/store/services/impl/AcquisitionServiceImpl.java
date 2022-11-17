package api.virtual.store.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.virtual.store.dto.AcquisitionDTO;
import api.virtual.store.handler.RulesException;
import api.virtual.store.model.Acquisition;
import api.virtual.store.model.Client;
import api.virtual.store.model.Product;
import api.virtual.store.repositories.AcquisitionRepository;
import api.virtual.store.repositories.ClientRepository;
import api.virtual.store.repositories.ProductRepository;
import api.virtual.store.services.AcquisitionService;


@Service
public class AcquisitionServiceImpl implements AcquisitionService {

	@Autowired
	private AcquisitionRepository acquisitionRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
		
	@Override
	public void newAcquisition(AcquisitionDTO acquisitionDTO) {
		saveAcquisition(acquisitionDTO);
	}

	@Override
	public Iterable<Acquisition> allAcquisition(){
		return acquisitionRepository.findAll();
	}

	@Override 
	public Acquisition findAquisitionById(Long id){
		Optional<Acquisition> acquisition = acquisitionRepository.findById(id);
		return acquisition.get();
	}
	
	@Override
	public void update(Long id, AcquisitionDTO acquisitionDTO){
		saveAcquisition(acquisitionDTO);
	}
	
	@Override
	public void deleteAcquisition(Long id){
		acquisitionRepository.deleteById(id);
	}
	
	private void saveAcquisition(AcquisitionDTO acquisitionDTO) {
		Long idCliente = acquisitionDTO.getClientId();
		Client client = clientRepository.findById(idCliente)
				.orElseThrow(() -> new RulesException("Client not found"));
		
		Long product_id = acquisitionDTO.getProductId();
		Product product = productRepository.findById(product_id)
				.orElseThrow(() -> new RulesException("Product not found"));

		Acquisition acquisition = new Acquisition();
		
		BigDecimal total = acquisitionDTO.getTotal().multiply(product.getPrice());
		acquisition.setTotal(total);
		
		acquisition.setDateAcquisition(LocalDate.now());
		acquisition.setClient(client);
		acquisition.setProduct(product);
		
		acquisitionRepository.save(acquisition);
	}
}
