package pl.devs.mentoring.webstart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.devs.mentoring.webstart.model.Course;
import pl.devs.mentoring.webstart.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getCourses(@RequestParam(required = false, value = "category") List<String> categories) {
        return courseService.getCourses(categories);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody @Valid Course course) {
        courseService.createCourse(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping("/courses")
    public void deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
    }
}
