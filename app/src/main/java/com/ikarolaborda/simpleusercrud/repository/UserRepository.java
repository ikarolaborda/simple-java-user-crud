package com.ikarolaborda.simpleusercrud.repository;

import com.ikarolaborda.simpleusercrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
