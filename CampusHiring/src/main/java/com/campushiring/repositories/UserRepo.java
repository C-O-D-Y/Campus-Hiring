package com.campushiring.repositories;

import java.util.HashSet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.campushiring.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	@Query(value = "SELECT Response.user_id" + " from Response "
			+ " where Response.test_id= :test_Id", nativeQuery = true)
	HashSet<Long> findByTestId(@Param("test_Id") String test_id);
}
