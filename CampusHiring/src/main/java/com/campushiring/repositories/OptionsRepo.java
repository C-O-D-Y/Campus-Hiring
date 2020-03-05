package com.campushiring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campushiring.entity.Options;

@Repository
public interface OptionsRepo extends CrudRepository<Options, Integer> {

	@Query(value = "SELECT * FROM public.options where fk_questions_id= :fkQuestionId", nativeQuery = true)
	List<Options> findByForeignKey(@Param("fkQuestionId") int fkQuestionId);
}



