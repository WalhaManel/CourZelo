package com.example.test2.Repositories;

import com.example.test2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long>{
}
