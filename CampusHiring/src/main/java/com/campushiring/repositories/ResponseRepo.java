package com.campushiring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campushiring.pojo.Response;

public interface ResponseRepo extends CrudRepository<Response, Integer> {
	
	public Response findByQuestionId(int questionId);
	
	 public Response findByQuestionIdAndUserId(Integer qid, Long uid);
}
