package io.aki.userservice.repository;

import io.aki.userservice.entity.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserName,Long> {

    UserName findByUserId(Long userId);
}
