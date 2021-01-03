package edu.prahlad.dp.cdp.builder2;

import edu.prahlad.dp.cdp.builder.Address;
import edu.prahlad.dp.cdp.builder.User;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

    public static void main(String[] args) {
        User user = createUser();
        UserDTO userDTO = directBuild(UserDTO.getBuilder(), user);
        System.out.println(userDTO);
    }

    //Director
    private static UserDTO directBuild(UserDTO.UserDTOBuilder userDTOBuilder, User user){
        return userDTOBuilder
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthday(user.getBirthday())
                .build();
    }

    /**
     * Returns a sample user.
     */
    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1960, 5, 6));
        user.setFirstName("Ron");
        user.setLastName("Swanson");
        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipcode("47998");
        user.setAddress(address);
        return user;
    }
}
