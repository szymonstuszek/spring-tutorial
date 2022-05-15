package pl.devs.mentoring.webstart.service;

import org.springframework.stereotype.Service;
import pl.devs.mentoring.webstart.exception.CourseNotFoundException;
import pl.devs.mentoring.webstart.model.Course;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void initCourses() {
        courses.add(new Course(
                5L,
                "Git basics",
                "John",
                "Tools",
                "Basics of Git version control")
        );
        courses.add(new Course(
                6L,
                "Java concurrency",
                "Marc",
                "Programming",
                "Java multithreading and concurrency")
        );
        courses.add(new Course(
                7L,
                "SQL Procedures",
                "Steven",
                "Programming",
                "Writing performant procedures in SQL")
        );
        courses.add(new Course(
                8L,
                "Algorithm interview prep",
                "Steven",
                "Interview",
                "Solving algorithms")
        );
    }

    public List<Course> getCourses(List<String> categories) {
        return categories != null ? courses.stream()
                    .filter(course -> categories.stream()
                            .anyMatch(category -> course.getCategory().equals(category)))
                    .collect(Collectors.toList())
                : courses;
    }

    public Course getCourse(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(Course courseToUpdate) {
        Long id = courseToUpdate.getId();

        courses.stream()
                .filter(course -> course.getId().equals(id))
                .findAny()
                .ifPresentOrElse(
                        c -> {
                            c.setAuthor(courseToUpdate.getAuthor());
                            c.setTitle(courseToUpdate.getTitle());
                            c.setCategory(courseToUpdate.getCategory());
                            c.setDescription(courseToUpdate.getDescription());
                        },
                        () -> {throw new CourseNotFoundException(id);}
                );
    }

    public void deleteCourse(Long id) {
        courses.stream()
                .filter(course -> course.getId().equals(id))
                .findAny()
                .ifPresentOrElse(
                        courses::remove,
                        () -> {throw new CourseNotFoundException(id);}
                );
    }
}
