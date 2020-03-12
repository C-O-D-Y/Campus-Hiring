package com.campushiring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campushiring.entity.Options;

@Repository
public interface OptionsRepo extends JpaRepository<Options, Integer> {

	@Query(value = "SELECT * FROM public.options where fk_questions_id= :fkQuestionId", nativeQuery = true)
	List<Options> findByForeignKey(@Param("fkQuestionId") int fkQuestionId);

	@Query(value = "select  * from \"options\" join \"response\" on \"response\".selected_option_id = \"options\".option_id where \"response\".user_id= :user_Id", nativeQuery = true)
	List<Options> findByUserId(@Param("user_Id") long user_Id);

//	@Query(value = "SELECT Response.test_id, Options.is_true,Response.question_id,Response.user_id"
//			+ " from Options join Response on Response.selected_option_id = Options.option_id"
//			+ " where Response.user_id= :user_Id", nativeQuery = true)
//	List<OptionsProjection> findByTestId(@Param("user_Id") String user_Id);

//	 @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM options c JOIN c.products p")
//	 List<Results> findByDto();
}
