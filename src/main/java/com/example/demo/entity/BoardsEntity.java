package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class BoardsEntity {
	private int id;
	private String title;
	private String explaination;
	private Date created;
}
