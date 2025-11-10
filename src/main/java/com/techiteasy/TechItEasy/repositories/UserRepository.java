package com.techiteasy.TechItEasy.repositories;

import com.techiteasy.TechItEasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
