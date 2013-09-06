package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CommandeDao;
import fr.treeptik.entity.Commande;
import fr.treeptik.service.CommandeService;

@Service(value = "commandeManager")
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	private CommandeDao commandeDao;

	@Override
	@Transactional
	public void add(Commande product) {
		commandeDao.save(product);

	}

	@Override
	public List<Commande> getAll() {
		return commandeDao.findAll();
	}

	@Override
	public Commande get(Integer id) {
		return commandeDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Integer commandeId) {
		commandeDao.delete(commandeId);

	}

}
