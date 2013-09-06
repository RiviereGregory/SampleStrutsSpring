package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Commande;

public interface CommandeService {
	public void add(Commande commande);

	public List<Commande> getAll();

	public Commande get(Integer id);

	public void delete(Integer commandeId);
}
