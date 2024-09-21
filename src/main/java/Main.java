import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("main");

        ObjectMapper om = new ObjectMapper();

        User user = new User();
        user.setName("AA");
        user.setAge(30);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNum("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q9");
        car2.setCarNum("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        //System.out.println(user);

        String json = null;
        try {
            json = om.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);
    }
}
