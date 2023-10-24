import helpers.Utils;
import model.User;

public class Main {

    public static Integer disc(Integer a, Integer b, Integer c){
        return b * b - 4 * a * c;
    }

    public static void main(String[] args) {
        System.out.println(disc(-1, -3, -2));
        User user = User.builder()
                .firstName(Utils.genFirstName())
                .lastName((Utils.genLastName()))
                .phone(Utils.genPhone())
                .address(Utils.genAddress())
                .gender(Utils.genGender())
                .build();
        System.out.println(user);

    }
}
