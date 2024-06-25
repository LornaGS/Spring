package com.qa.repos;

import com.qa.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cat, Integer> {
}
