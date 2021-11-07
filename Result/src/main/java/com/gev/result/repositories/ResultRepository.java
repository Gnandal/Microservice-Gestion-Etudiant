package com.gev.result.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gev.result.models.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
