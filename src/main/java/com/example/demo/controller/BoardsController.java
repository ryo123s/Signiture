package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.BoardsEntity;
import com.example.demo.service.BoardsService;

@Controller
public class BoardsController {
	@Autowired
	BoardsService boardsService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<BoardsEntity> boardsList = boardsService.getBoardsList();
		String data = "";
		for(BoardsEntity item: boardsList) {
			String addData = "{" + "\"id\":\"" + item.getId() + "\",\"title\":\"" + item.getTitle() + "\",\"explaination\":\"" + item.getExplaination() + "\",\"created\":\"" + item.getCreated() + "\"}";
			data = data + addData + ", ";
		}
		
		String list_data = data.substring(0, data.length()-2);
		String send_data = "[" + list_data + "]";
		
		model.addAttribute("send_data", send_data);
		return "index";
	}
	
	
	@RequestMapping(value = "getBoards", method = RequestMethod.GET)
	@ResponseBody
	public String getBoards(){
		System.out.println("getBoardsコントローラー起動");
		List<BoardsEntity> boardsList = boardsService.getBoardsList();
		String data = "";
		for(BoardsEntity item: boardsList) {
			String addData = "{ " + "\"id\" : \"" + item.getId() + "\" , \"title\" : \"" + item.getTitle() + "\" , \"explaination\" : \"" + item.getExplaination() + "\" , \"created\" : \"" + item.getCreated() + "\"}";
			data = data + addData + ", ";
		}
		
		String send_data = data.substring(0, data.length()-2);
		System.out.println(send_data);
		return send_data;
	}
	
}
