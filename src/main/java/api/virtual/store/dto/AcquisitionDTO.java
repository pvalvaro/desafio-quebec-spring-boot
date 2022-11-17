package api.virtual.store.dto;

import java.math.BigDecimal;
import java.util.List;

import api.virtual.store.model.Address;
import api.virtual.store.model.Client;
import api.virtual.store.model.Product;

public class AcquisitionDTO {
	
	private Long clientId;
	private Long productId;
	private BigDecimal total;
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
