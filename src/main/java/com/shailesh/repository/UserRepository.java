package com.shailesh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shailesh.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}
