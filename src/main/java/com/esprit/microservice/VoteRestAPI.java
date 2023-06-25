package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/votes")
public class VoteRestAPI {
	
	private String title = "Hello; I'm the vote Microservice for Week 3";
	
	@Autowired
	private VoteService voteService;
	
	//http://localhost:8181/hello
	//Resultat -> Message: Hello; I'm the votee Microservice for Week 3
	//Execution URL: http://localhost:8282/api/votes/hello
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	//Configuration de la methode POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Vote> createVote(@RequestBody Vote vote){
		return new ResponseEntity<>(voteService.addVote(vote), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/votes/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Vote> updateVote(@PathVariable(value = "id") int id,
			@RequestBody Vote vote){
		return new ResponseEntity<>(voteService.updateVote(id, vote), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/votes/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Vote> deleteVote(@PathVariable(value = "id") int id){
		voteService.deleteVote(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/votes/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Vote> getAllVotes(){
		return voteService.GetVotes();
	}
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode de recherche GET specifique avec PathParam
	//il faut que les noms des methodes ici vote Resst API) et celles dans voteService n'aient pas le meme nom, sinon ca degere une erreue de mapping
	//Execution URL: http://localhost:8282/api/votes
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Vote> searchVote(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(voteService.findVote(id) , HttpStatus.OK);
	}
	
	
	

}
