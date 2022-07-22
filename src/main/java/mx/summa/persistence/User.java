package mx.summa.persistence;

import java.util.List;

public class User {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Role> roles;
    private List<UserSeller> sellers;
    private Boolean emailNotification;
    private Boolean textMessageNotification;
    private String auth0Id;
    private String _class;

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<UserSeller> getSellers() {
        return sellers;
    }

    public void setSellers(List<UserSeller> sellers) {
        this.sellers = sellers;
    }

    public Boolean getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Boolean getTextMessageNotification() {
        return textMessageNotification;
    }

    public void setTextMessageNotification(Boolean textMessageNotification) {
        this.textMessageNotification = textMessageNotification;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                ", sellers=" + sellers +
                ", emailNotification=" + emailNotification +
                ", textMessageNotification=" + textMessageNotification +
                ", auth0Id='" + auth0Id + '\'' +
                '}';
    }
}
