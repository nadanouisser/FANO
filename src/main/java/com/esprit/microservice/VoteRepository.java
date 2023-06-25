package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
	//Requete de recherche d'un vote par son content
	//http://localhost:8181/candidats/search/candidatByNom?nom=Sarra
	@Query("select c from Vote c where c.content like :content")
	public Page<Vote> VoteByNom(@Param("content") String n, Pageable pageable);
	
}
