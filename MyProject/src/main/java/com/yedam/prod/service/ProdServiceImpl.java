package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.mapper.ProdMapper;

public class ProdServiceImpl implements ProdService {
	SqlSession session = DataSource.getInstance().openSession(true);
	ProdMapper mapper = session.getMapper(ProdMapper.class);

	@Override
	public List<ProductVO> prodList() {
		return mapper.prodList();
	}

	@Override
	public ProductVO getProdeuct(String prodCode) {
		return mapper.selectProduct(prodCode);
	}

	@Override
	public List<ProductVO> relatedProduct() {
		return mapper.relatedProduct();
	}

	@Override
	public boolean addProduct(ProductVO vo) {
		return mapper.insertProduct(vo) == 1;
	}

}
