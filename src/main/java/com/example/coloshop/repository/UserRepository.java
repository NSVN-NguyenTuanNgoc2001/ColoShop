package com.example.coloshop.repository;


import com.example.coloshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findById(int id);
    Iterable<User>findAllByUsernameContaining(String name);


}
