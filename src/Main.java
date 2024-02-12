import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Publication Year: " + book.getPublicationYear());
            }
        }
    }
}

class Student {
    private String name;
    private int id;
    private int age;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}

class Grade {
    private Student student;
    private String subject;
    private double grade;

    public Grade(Student student, String subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }
}

class StudentManager {
    private List<Student> students;
    private Map<Student, List<Grade>> grades;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        grades.put(student, new ArrayList<>());
    }

    public void addGrade(Student student, String subject, double grade) {
        if (grades.containsKey(student)) {
            grades.get(student).add(new Grade(student, subject, grade));
        }
    }

    public double getAverageGrade(Student student) {
        if (grades.containsKey(student)) {
            List<Grade> studentGrades = grades.get(student);
            if (!studentGrades.isEmpty()) {
                double totalGrade = 0;
                for (Grade grade : studentGrades) {
                    totalGrade += grade.getGrade();
                }
                return totalGrade / studentGrades.size();
            }
        }
        return 0.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Initial books in the library:");
        library.printBooks();

        Book book3 = new Book("1984", "George Orwell", 1949);
        library.addBook(book3);

        System.out.println("\nBooks in the library after adding a new book:");
        library.printBooks();

        library.removeBook(book2);

        System.out.println("\nBooks in the library after removing a book:");
        library.printBooks();

        StudentManager studentManager = new StudentManager();

        Student student1 = new Student("Ringo Starr", 1, 22);
        Student student2 = new Student("Paul Maccartney", 2, 20);

        studentManager.addStudent(student1);
        studentManager.addStudent(student2);

        studentManager.addGrade(student1, "Math", 85.5);
        studentManager.addGrade(student1, "History", 78.0);
        studentManager.addGrade(student2, "Math", 90.0);
        studentManager.addGrade(student2, "History", 88.5);

        System.out.println("\nAverage grade for " + student1.getName() + ": " +
                studentManager.getAverageGrade(student1));

        System.out.println("Average grade for " + student2.getName() + ": " +
                studentManager.getAverageGrade(student2));
    }
}
