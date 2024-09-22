import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
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

        String json = om.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = om.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _car = om.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_car);
    }
}
