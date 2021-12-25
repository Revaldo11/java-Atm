public class User {
    private int id;
    private String nama;
    private String username;
    private String password;

    public User() {
    }

    protected void setUser(int id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    protected boolean checkUser(int id, String nama, String username, String password) {
        if (this.id == id && this.nama.equals(nama) && this.username.equals(username) && this.password.equals(password)) {
            return true;
        } return false;
    }
}
