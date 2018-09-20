package net.skhu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("/")
public class AppController{

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;
    @Autowired ProfessorMapper professorMapper;

    @RequestMapping("/home/test1")
    public String test1(Model model) {
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        return "home/test1";
    }

    @RequestMapping("/home/test2")
    public String test2(Model model) {
        model.addAttribute("number", 123);
        return "home/test2";
    }

    @RequestMapping("/c201432005/list1")
    public String list1(Model model) {

    	List<Professor> professors= professorMapper.findAll();
    	 model.addAttribute("professors", professors);
        return "c201432005/list1";
    }

    @RequestMapping("/c201432005/list2")
    public String list2(Model model,@RequestParam("departmentId") int departmentId) {

    	List<Professor> professors= professorMapper.findByDepartment(departmentId);
    	model.addAttribute("departmentId",departmentId);
    	 model.addAttribute("professors", professors);

        return "c201432005/list2";
    }



    @RequestMapping(value="/c201432005/edit",method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
    	List<Department> departments = departmentMapper.findAll();
    	Professor professor= professorMapper.findOne(id);
    	 model.addAttribute("professor", professor);
    	 model.addAttribute("departments", departments);
        return "c201432005/edit";
    }




}