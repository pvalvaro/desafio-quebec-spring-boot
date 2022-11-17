package api.virtual.store.services;

import api.virtual.store.dto.AcquisitionDTO;
import api.virtual.store.model.Acquisition;

public interface AcquisitionService {

	Iterable<Acquisition> allAcquisition();
	Acquisition findAquisitionById(Long id);
	void newAcquisition(AcquisitionDTO acquisitionDTO);
	void update(Long id, AcquisitionDTO acquisitionDTO);
	void deleteAcquisition(Long id);
}
