package model;

public class Admin {
    private int id;
    private int userId;

    public Admin() {}

    public Admin(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Admin{" +
               "id=" + id +
               ", userId=" + userId +
               '}';
    }
}
