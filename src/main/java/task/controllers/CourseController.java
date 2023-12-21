package task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import task.entities.Course;
import task.services.CourseService;

@RestController
public class CourseController {
	
	 @Autowired
	    private CourseService courseService;

	    @GetMapping("/getAllCourses")
	    public List<Course> getAllCourses() {
	        return courseService.getAllCourses();
	    }

	    @PostMapping("/courses/add")
	    public Course addCourse(@RequestBody Course course) {
	        return courseService.addCourse(course);
	    }
	    
	    @DeleteMapping("/courses/delete/{courseId}")
	    public void deleteCourse(@PathVariable Integer courseId) {
	        courseService.deleteCourse(courseId);
	    }

	    @PutMapping("/courses/update/{courseId}")
	    public void updateCourse(@PathVariable int courseId, @RequestBody Course updatedCourse) {
	        courseService.updateCourse(courseId, updatedCourse);
	    }
		

}
