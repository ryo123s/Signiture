package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BoardsEntity;
import com.example.demo.mapper.BoardsMapper;

@Service
public class BoardsService implements BoardsMapper{
	@Autowired
	BoardsMapper boardsMapper;
	
	@Override
	public List<BoardsEntity> getBoardsList(){
		return boardsMapper.getBoardsList();
	}
}
