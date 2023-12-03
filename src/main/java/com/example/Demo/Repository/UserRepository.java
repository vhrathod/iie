package com.example.Demo.Repository;

import com.example.Demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    @Query("SELECT e FROM UserEntity e WHERE e.role = :role")
    List<UserEntity> findAllByRole(@Param("role") String role);

    @Query("SELECT e FROM UserEntity e WHERE e.role = ?1")
    List<UserEntity> findByRole(String role);

    @Query("Select e from UserEntity e where e.username IN :username")
    List<UserEntity> findAllByUserName(@Param("username") List<String> username);
}

