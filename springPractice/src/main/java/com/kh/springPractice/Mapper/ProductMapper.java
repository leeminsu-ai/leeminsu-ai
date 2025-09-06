package com.kh.springPractice.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springPractice.dto.ProductDto;
@Component
public class ProductMapper implements RowMapper<ProductDto> {

	public ProductDto mapRow(ResultSet rs,int rowNum)throws SQLException{
		
        ProductDto productDto = new ProductDto();
        productDto.setProductId(rs.getInt("product_id"));
        productDto.setProductCode(rs.getString("product_cod"));
        productDto.setProductName(rs.getString("product_name"));
        productDto.setProductPrice(rs.getInt("product_price")); // NUMBER(12,0)
        productDto.setProductStock(rs.getInt("product_stoc"));       // NUMBER(10,0)
        productDto.setThumbName(rs.getString("thumb_name"));
        productDto.setStatus(rs.getString("status"));
        productDto.setCreatedAt(rs.getTimestamp("created_at"));
        return productDto;

	}
}
