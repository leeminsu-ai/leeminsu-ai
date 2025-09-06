package com.kh.springPractice.dto;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class ProductDto {

	    private int productId;
	    private String productCode;
	    private String productName;
	    private int productPrice;
	    private int productStock;
	    private String thumbName;
	    private String status;
	    private Timestamp createdAt;
}
