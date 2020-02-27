package com.campushiring.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepo extends CrudRepository<Options, Integer> {

	@Query(value = "SELECT * FROM public.options where fk_questions_id= :fkQuestionId", nativeQuery = true)
	List<Options> findByForeignKey(@Param("fkQuestionId") int fkQuestionId);
}



