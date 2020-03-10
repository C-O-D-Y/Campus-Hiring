package com.campushiring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campushiring.entity.Options;
import com.campushiring.pojo.Results;

@Repository
public interface OptionsRepo extends JpaRepository<Options, Integer> {

	@Query(value = "SELECT * FROM public.options where fk_questions_id= :fkQuestionId", nativeQuery = true)
	List<Options> findByForeignKey(@Param("fkQuestionId") int fkQuestionId);

	@Query(value = "select  * from \"options\" join \"response\" on \"response\".selected_option_id = \"options\".option_id where \"response\".user_id= :user_Id", nativeQuery = true)
	List<Options> findByUserId(@Param("user_Id") long user_Id);

	@Query(value = "SELECT new com.campushiring.pojo.Results(\"response\".test_id, \"options\".is_true,\"options\".fk_questions_id,\"response\".user_id) from \"options\" join \"response\" on \"response\".selected_option_id = \"options\".option_id where \"response\".test_id= :test_Id", nativeQuery = true)
	List<Results> findByTestId(@Param("test_Id") String test_Id);
	
//	 @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM options c JOIN c.products p")
//	 List<Results> findByDto();
}
