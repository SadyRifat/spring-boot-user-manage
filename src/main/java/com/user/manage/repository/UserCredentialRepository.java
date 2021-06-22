package com.user.manage.repository;

import com.user.manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.username=:username")
    Optional<User> findByUsername(String username);
}
