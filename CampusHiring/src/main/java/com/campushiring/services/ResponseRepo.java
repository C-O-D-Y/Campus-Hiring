package com.campushiring.services;

import org.springframework.data.repository.CrudRepository;

public interface ResponseRepo extends CrudRepository<Response, Integer> {
	
	public Response findByQuestionId(int questionId);
	
	 public Response findByQuestionIdAndUserId(Integer qid, Long uid);
}
