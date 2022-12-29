package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.BoardsEntity;

@Mapper
public interface BoardsMapper {
	@Select("select id, title, explaination, created from boards")
	List<BoardsEntity> getBoardsList();
}
