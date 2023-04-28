package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProdMapper {
	public List<ProductVO> prodList();
	public ProductVO selectProduct(String prodCode);
	public List<ProductVO> relatedProduct();
	public int insertProduct(ProductVO vo);
}
