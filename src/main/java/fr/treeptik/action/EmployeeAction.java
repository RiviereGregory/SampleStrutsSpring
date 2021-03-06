package fr.treeptik.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.entity.Employee;
import fr.treeptik.service.EmployeeService;

@Component(value = "employeeAction")
@Scope("prototype")
// Permet d'identifier les pages appele et de mettre directement la methode dans les pages jsp sans
// avoir tous le chemin
// ModelDriven permet de savoir quel model est utilise dans les pages jsp du namespace
@Namespace("/employee")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeService employeeService;

	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<>();

	private Integer idToDelete;

	// On choisi le model que l'on veut dans les pages du formulaire
	@Override
	public Employee getModel() {
		return employee;
	}

	// Permat de faire de la validation directement sur toute les méthode sauf celle annoté
	// SkipValidation
	public void validate() {

		if (getEmployee().getFirstname().trim().length() == 0) {
			addFieldError("firstname", "First name is required.");
		}
		if (getEmployee().getLastname().trim().length() == 0) {
			addFieldError("lastname", "last name is required.");
		}

		// Permet de tester l'expression de l'email
		if (!getEmployee().getEmail().matches("(.*)@(.*)")) {
			addFieldError("email", "Entrer un email valide");
		}

	}

	// Permet d'appeler l'url .action directement
	// Result succes permet d'aller sur la page en cas de réussite
	// Result input permet de rester sur la page en cas d'echec
	@Action(value = "addAction", results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/employee/add.jsp") })
	public String addEmployee() throws Exception {
		System.out.println("ADD EMPLOYEE");

		System.out.println(employee);

		employeeService.add(employee);

		return "success";
	}

	@Action(value = "listAction", results = { @Result(name = "success", location = "/employee/list.jsp") })
	@SkipValidation
	public String listEmployees() throws Exception {
		employees = employeeService.getAll();

		return "success";
	}

	@Action(value = "suppAction", results = { @Result(name = "success", type = "redirectAction", location = "listAction.action") })
	@SkipValidation
	public String suppEmployee() throws Exception {
		System.out.println("DELETE ID : " + idToDelete);
		employeeService.delete(idToDelete);

		return "success";
	}

	@Action(value = "modifAction", results = { @Result(name = "success", location = "/employee/add.jsp") })
	@SkipValidation
	public String modifEmployee() throws Exception {
		System.out.println("Employee : " + employee);

		return "success";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Integer getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(Integer idToDelete) {
		this.idToDelete = idToDelete;
	}

}