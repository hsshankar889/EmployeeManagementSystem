package com.example.EmployeApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	EmployeeDao emp;
	
	@GetMapping("/")
	public String load(Model m)
	{
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
		return "Display.html";
	}
	
	@GetMapping("/add")
	public String addFun(@ModelAttribute Employee e,HttpSession session,Model m)
	{
		
		System.out.println(e.getEmployeePassword());
		System.out.println(e.getEmployeeGender()+e.getEmployeeSalary());
		System.out.println(e);
		try {
		boolean o=emp.add(e);
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
		m.addAttribute("simple", "the data added sucessfull");
 		session.setAttribute("message","the data added Successfully");
		return "redirect:/";

		}
		catch (Exception oe) {
			List<Employee> data = emp.fetch();
			m.addAttribute("data", data);
			m.addAttribute("simple", "the data added sucessfull");
			session.setAttribute("message","the data not added Successfully");
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/deleteAll")
	public String deleteAllFun(@RequestParam String deleteAll,Model m,HttpSession session)
	{
		System.out.println(deleteAll);
		if(deleteAll.equals("yes"))
		{
			List<Employee> data = emp.fetch();
			emp.deleteAll(data);
			System.out.println("deleted all done");
			session.setAttribute("message","All the records deleted Sucessfully");
			return "redirect:/";
		}
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
 		return "Display.html";
	}
	
	@GetMapping("/updateFun")
	public String updateFun(@RequestParam int id,Model m,HttpSession session)
	{
		System.out.println(id+"+++++++++++++++++++++++++++++++++++++++++++++++++++");
		    Optional<Employee> op = emp.fetchData(id);
		    Employee data=op.get();
		    if(data==null)
		    {
				session.setAttribute("message","No Record Found");
				return "rediect:/";
		    }
		    System.out.println(data+"__________________________________________________________");
		m.addAttribute("val", data);
		System.out.println(data);
		return "update.html";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute Employee e,Model m,HttpSession session)
	{
		emp.update(e);
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
		session.setAttribute("message","The Record Updated Sucessfully");
		return "redirect:/";
	}
	
	@GetMapping("/ucancel")
	public String cancel(Model m,HttpSession session)
	{
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
		session.setAttribute("message","You came to main page");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete")
	public String deleteFun(@RequestParam int delete ,Model m,HttpSession session)
	{
		Optional<Employee> d = emp.fetchData(delete);
		Employee op=d.get();
		if(op==null)
		{
			session.setAttribute("message","No Record Found");
			return "rediect:/";
		}
		emp.deleteRecord(delete);
		List<Employee> data = emp.fetch();
		m.addAttribute("data", data);
		session.setAttribute("message","The Record Deleted Sucessfully");
		return "redirect:/";
	}
}
