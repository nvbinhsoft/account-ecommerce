package com.ecommerce.account.repository;


import com.ecommerce.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, BaseUserRepository {

}
