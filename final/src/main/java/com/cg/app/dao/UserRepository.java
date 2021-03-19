package com.cg.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
