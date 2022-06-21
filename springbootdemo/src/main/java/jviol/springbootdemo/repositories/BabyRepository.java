package jviol.springbootdemo.repositories;

import jviol.springbootdemo.entities.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BabyRepository extends JpaRepository<Baby, Long> {
    Optional<Baby> findByName(@Param("name") String name);
}
