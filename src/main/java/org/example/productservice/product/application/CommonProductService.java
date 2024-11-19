package org.example.productservice.product.application;
import java.util.List;
import org.example.productservice.product.dto.out.GetProductContentResponseDto;

public interface CommonProductService {

	List<GetProductContentResponseDto> getProductContentList(String productUuid);
}
