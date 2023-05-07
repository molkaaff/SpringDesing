package com.tp.soap_wsdl_uddi.repositories;

import com.tp.soap_wsdl_uddi.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
