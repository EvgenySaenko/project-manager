package com.projectmanager.repositories;

import com.projectmanager.persistence.entity.Subproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubprojectRepository extends JpaRepository<Subproject, Long> {
}
