package com.bitcamp.lecture.comm;

import java.util.ArrayList;
import java.util.List;

public class Notice {
	
	public static List<Notice> list =new ArrayList<>();
	
	private int id =0;
	private String title =null;
	private String writerId =null;
	private String content =null;
	private String regdate =null;
	private int hit =0;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String writerId, String content, String regdate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
	}

	public static List<Notice> getList() {
		return list;
	}

	public static void setList(List<Notice> list) {
		Notice.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
