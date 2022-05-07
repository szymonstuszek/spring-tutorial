package pl.devs.mentoring.webstart.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Course {
    private Long id;

    @NotBlank(message = "Title can not be blank")
    private String title;

    @NotBlank(message = "Author can not be blank")
    private String author;

    @NotBlank(message = "Category can not be blank")
    private String category;

    @Size(min = 10, message = "Description should be at least 10 characters long")
    private String description;

    public Course(Long id, String title, String author, String category, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
