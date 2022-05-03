package pl.devs.mentoring.webstart.model;

//task: find what annonation allows to return non-null values
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    private Long id;
    private String title;
    private String author;
    private String category;
    private String description;

    //stwórz konstruktor i gettery

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
