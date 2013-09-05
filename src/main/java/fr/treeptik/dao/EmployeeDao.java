package fr.treeptik.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.entity.Employee;

// On a que des interfaces car on utilise spring data qui permet de faire les class automatiquement on ajoute que les signature avec les requetes autre que le crud qui sont déjà dans le model
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	// On met les requetes directement
	@Query("select e from Employee e where e.email=:email")
	public Employee findOneByEmail(@Param("email") String email);

	@Query("select e from Employee e where e.lastname=:lastname")
	public List<Employee> findAllByLastname(@Param("lastname") String lastname);

}