package com.campushiring.pojo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Result {

	private long user_id;

	
	private ArrayList<HashMap<Integer, String>> res = new ArrayList<HashMap<Integer, String>>();

	public Result() {

	}

	public Result(long user_id, ArrayList<HashMap<Integer, String>> res) {
		super();
		this.user_id = user_id;
		this.res = res;

	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public ArrayList<HashMap<Integer, String>> getRes() {
		return res;
	}

	public void setRes(ArrayList<HashMap<Integer, String>> res) {
		this.res = res;
	}

}
