package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProductVO {
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private int price;
	private int salePrice;
	private int likeIt;
	private String prodImage;
}
