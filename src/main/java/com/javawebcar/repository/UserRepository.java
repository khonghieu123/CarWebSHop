package com.javawebcar.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javawebcar.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    boolean existsByUsername(String username);

    @Override
    <S extends User> List<S> saveAllAndFlush(Iterable<S> entities);
}
