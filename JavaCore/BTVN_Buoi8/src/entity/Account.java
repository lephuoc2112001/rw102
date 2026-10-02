package entity;

public class Account {
    private int id;
    private String username;
    private String fullName;
    private Department department;
    private Position position;

    public Account() {
    }

    public Account(int id, String username, String fullName, Department department, Position position) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
