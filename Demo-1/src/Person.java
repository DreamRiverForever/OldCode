public class Person {
    private String name;
    private String password;
    private String iname;

    public Person(String name, String password, String iname) {
        this.name = name;
        this.password = password;
        this.iname = iname;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIname() {
        return iname;
    }
}
