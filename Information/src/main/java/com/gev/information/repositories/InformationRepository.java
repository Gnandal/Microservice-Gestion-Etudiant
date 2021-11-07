package com.gev.information.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gev.information.models.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long>{

}
