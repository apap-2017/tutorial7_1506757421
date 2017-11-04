package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController {
	@Autowired
    CourseService courseDAO;
	
	@RequestMapping("/course/view/{id}")
    public String view (Model model,
            @PathVariable(value = "id") String id)
    {
        CourseModel course = courseDAO.selectCourse (id);

        if (course != null) {
            model.addAttribute ("course", course);
            return "view-course";
        } else {
            model.addAttribute ("id", id);
            return "not-found-course";
        }
    }
	
	@RequestMapping("/course/viewall")
    public String viewAll (Model model)
    {
        List<CourseModel> courses = courseDAO.selectAllCourses ();

        if (courses != null) {
            model.addAttribute ("courses", courses);
            return "view-all-courses";
        } else {
            return "not-found-course";
        }
    }
}
