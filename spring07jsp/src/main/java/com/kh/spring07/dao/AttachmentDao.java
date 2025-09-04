package com.kh.spring07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.AttachmentDto;
import com.kh.spring07.mapper.AttachmentMapper;
@Repository
public class AttachmentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	public int sequence() {
		String sql="select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(AttachmentDto attachmentDto) {
		String sql="insert into attachment(번호,이름,유형,크기)values(?,?,?,?)";
		Object[] params= {
				attachmentDto.getAttachmentNo(),attachmentDto.getAttachmentName(),
				attachmentDto.getAttachmentType(),attachmentDto.getAttachmentSize()
		};
		jdbcTemplate.update(sql,params);
	}
}
