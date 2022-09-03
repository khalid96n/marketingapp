package com.marketing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entities.lead;

public interface leadRepository extends JpaRepository<lead, Long> {

}
