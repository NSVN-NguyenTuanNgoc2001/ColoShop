package com.example.coloshop.repository;

import com.example.coloshop.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    @Modifying
    @Query(value = "select name from role", nativeQuery = true)
    Iterable<String> findNameRole();
    Page<Role> findAllByNameContaining(Pageable pageable, String name);
}
