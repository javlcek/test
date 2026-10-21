package person;

public class AccountOwner {

    private String uuid;

    private String name;

    private String lastName;

    public AccountOwner(String uuid, String name, String lastName) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
