package com.ploverbay.ticketing.authentication.repository;

import com.ploverbay.ticketing.authentication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ '_id' : ?0 }")
    User findByUserId(String userId);

    @Query("{ 'emailAddress' : ?0 }")
    User findByEmail(String email);

    @Query("{ 'userDetails.firstName' : ?0, 'userDetails.lastName' : ?1 }")
    User findByUserDetailsFirstNameAndUserDetailsLastName(String firstName, String lastName);

}