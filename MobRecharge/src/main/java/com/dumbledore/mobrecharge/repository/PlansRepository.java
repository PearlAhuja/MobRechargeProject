package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dumbledore.mobrecharge.model.Plan;

public interface PlansRepository extends JpaRepository<Plan , Integer> {

}
