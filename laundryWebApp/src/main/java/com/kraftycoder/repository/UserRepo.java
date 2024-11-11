package com.kraftycoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraftycoder.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
