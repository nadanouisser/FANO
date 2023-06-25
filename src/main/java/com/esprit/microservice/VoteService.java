package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteService {

	
	@Autowired
	private VoteRepository VoteRepository;
	
	
	//Ajouter un Vote
	public Vote addVote(Vote vote) {
		return VoteRepository.save(vote);
	}
	
	
	//Mettre a jour les informations d'un Vote
	public Vote updateVote(int id, Vote newVote) {
		if(VoteRepository.findById(id).isPresent()) {
			Vote existingVote = VoteRepository.findById(id).get();
			existingVote.setContent(newVote.getContent());
			existingVote.setDate(newVote.getDate());
		
			
			return VoteRepository.save(existingVote);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un Vote
	public String deleteVote(int id) {
		if(VoteRepository.findById(id).isPresent()) {
			VoteRepository.deleteById(id);
			return "Le Vote avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le Vote avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les Votes
	public  List<Vote> GetVotes() {
		return VoteRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un Vote
	public Vote findVote(int id) {
		if(VoteRepository.findById(id).isPresent()) {
			Vote existingVote = VoteRepository.findById(id).get();
			return existingVote;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
