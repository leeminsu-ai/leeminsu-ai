package com.kh.springPractice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springPractice.Mapper.ProductMapper;
import com.kh.springPractice.dto.ProductDto;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private ProductMapper productMapper;
	
	public void insert(ProductDto dto) {
		
		String sql="""
		Insert into Product(product_Id,product_code,product_Name,product_price
							Product_Stock,thumbStock,status,createdAt)Values
							(member_seq.nextval,?,?,?,?,?,?,?)
						""";
		
		Object[]params= {
				dto.getProductId(),dto.getProductCode(),dto.getProductName(),dto.getProductPrice()
				,dto.getProductStock(),dto.getThumbName(),dto.getStatus(),dto.getCreatedAt()
				
			
		};
		jdbctemplate.update(sql,params);
	}
	
	public RowMapper<>
	
}
