package fr.treeptik.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import fr.treeptik.entity.Commande;
import fr.treeptik.entity.Employee;
import fr.treeptik.entity.Product;
import fr.treeptik.service.CommandeService;
import fr.treeptik.service.EmployeeService;
import fr.treeptik.service.ProductService;

@Component(value = "commandeAction")
@Scope("prototype")
@Namespace("/commande")
public class CommandeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private EmployeeService employeeService;

	private Commande commande = new Commande();
	private List<Commande> commandes;
	private Map<Integer, String> employees;
	private Map<Integer, String> products;

	private Integer idToDelete;

	@Action(value = "initAction", results = { @Result(name = "success", location = "/commande/add.jsp") })
	public String initCommande() throws Exception {
		System.out.println("Init Commande");

		employees = new HashMap<>();
		products = new HashMap<>();

		List<Employee> listEmployees = employeeService.getAll();
		for (Employee employee : listEmployees) {
			employees.put(employee.getId(), employee.toString());
		}

		List<Product> listProducts = productService.getAll();
		for (Product product : listProducts) {
			products.put(product.getId(), product.toString());
		}

		return "success";
	}

	@Action(value = "addAction", results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/commande/add.jsp") })
	public String addCommande() throws Exception {
		System.out.println("ADD Commande");

		// Product product = new Product();
		// product = productService.get(commande.getProduct().getId());
		// commande.setProduct(product);
		//
		// Employee employee = new Employee();
		// employee = employeeService.get(commande.getEmployee().getId());
		// commande.setEmployee(employee);

		System.out.println(commande);

		commandeService.add(commande);

		return "success";
	}

	@Action(value = "listAction", results = { @Result(name = "success", location = "/commande/list.jsp") })
	@SkipValidation
	public String listCommandes() throws Exception {

		commandes = commandeService.getAll();

		return "success";
	}

	@Action(value = "suppAction", results = { @Result(name = "success", type = "redirectAction", location = "listAction.action") })
	@SkipValidation
	public String suppCommande() throws Exception {
		System.out.println("DELETE ID : " + idToDelete);
		commandeService.delete(idToDelete);

		return "success";
	}

	@Action(value = "modifAction", results = { @Result(name = "success",  location = "/commande/add.jsp") })
	@SkipValidation
	public String modifCommande() throws Exception {
		System.out.println("Commande : " + commande);

		employees = new HashMap<>();
		products = new HashMap<>();

		List<Employee> listEmployees = employeeService.getAll();
		for (Employee employee : listEmployees) {
			employees.put(employee.getId(), employee.toString());
		}

		List<Product> listProducts = productService.getAll();
		for (Product product : listProducts) {
			products.put(product.getId(), product.toString());
		}
		
		return "success";
	}

	public Integer getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(Integer idToDelete) {
		this.idToDelete = idToDelete;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Map<Integer, String> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<Integer, String> employees) {
		this.employees = employees;
	}

	public Map<Integer, String> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, String> products) {
		this.products = products;
	}

}
