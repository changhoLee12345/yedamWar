package com.yedam.prod.service;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProdService {
	public List<ProductVO> prodList();
	public ProductVO getProdeuct(String prodCode);
	public List<ProductVO> relatedProduct();
	public boolean addProduct(ProductVO vo);
}
