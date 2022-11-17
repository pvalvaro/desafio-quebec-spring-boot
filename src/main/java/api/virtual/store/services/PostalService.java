package api.virtual.store.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import api.virtual.store.model.Address;


/**
 * CLIENT HTTP, criado via <b>Openfeing</b>, para o consumo da API do <b>ViaCEP</b>.
 * @author DIANGAZO-PC
 *
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface PostalService {

	@GetMapping(value = "/{zipcode}/json/")
	Address getZipCode(@PathVariable("zipcode") String zipcode);
}
