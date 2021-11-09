package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.ServiceProvider;
import com.dumbledore.mobrecharge.model.myenum.Provider;


@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider , Integer> {

	ServiceProvider findByProvider(Provider provider);

}
