package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.entity.Commande;

public interface CommandeDao extends JpaRepository<Commande, Integer> {

}