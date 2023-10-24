package model;

import lombok.Builder;
import lombok.Data;
import helpers.Utils;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private String gender;
    private String password;

    public static class UserBuilder {
        public User build(){
            email = Utils.genEmail(firstName, lastName);
            return new User(firstName, lastName, phone, address, email, gender, password);
        }
    }
}
