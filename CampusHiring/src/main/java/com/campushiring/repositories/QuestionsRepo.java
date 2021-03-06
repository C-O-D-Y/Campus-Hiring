package com.campushiring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campushiring.entity.Questions;

@Repository
public interface QuestionsRepo extends CrudRepository<Questions, Integer> {

	@Override
	@Query(value = "SELECT * FROM public.questions WHERE question_id = :id", nativeQuery = true)
	Optional<Questions> findById(@Param("id") Integer status);
}
