package com.shoppinglist.backend.repositories;

import com.shoppinglist.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findUserByUsernameAndDeleted(String username, boolean deleted);
}
