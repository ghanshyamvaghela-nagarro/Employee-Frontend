package com.employee.controller;

import java.util.List;
import com.employee.util.EmployeeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@Controller
public class HomePageController {

    private final EmployeeUtil employeeUtil;

	private final EmployeeService employeeService;
	
	
	public HomePageController(EmployeeService employeeService, EmployeeUtil employeeUtil) {
		this.employeeService = employeeService;
		this.employeeUtil = employeeUtil;
	}

	@GetMapping("/")
	public String getIndexPage(Model model) {
		return "home.html";
	}

	@GetMapping("/add")
	public String getAddPage(Model model) {
		return "add";
	}

	@PostMapping("/add-data")
	public String addEmployee(@ModelAttribute EmployeeDto employeeDto, Model model) {

		employeeService.addData(employeeDto);
		return "redirect:/";
	}

	@GetMapping("/list")
	public ModelAndView getListPage() {
		List<EmployeeDto> employees = employeeService.getData();
		ModelAndView mv = new ModelAndView("list");
	    mv.addObject("employees", employees);
		return mv;
	}
}

