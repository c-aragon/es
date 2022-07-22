package mx.summa.persistence;

public class UserSeller {

    private String id;
    private String name;
    private String accountName;

    public UserSeller() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "UserSeller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
