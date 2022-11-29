package com.customquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //@Query(value = "SELECT u from User u where  u.name = ?1 AND u.email = ?2")
    @Query(value = "SELECT u from User u where  u.name=:n AND u.email =:e")
    User findByNameAndEmail(@Param("n") String name,@Param("e") String email);
    @Query(value="SELECT u from User u where u.name = ?1")
User findByByName(String name);
    @Query(value="select * from user", nativeQuery = true)
   List<User> getAllUser();
}
