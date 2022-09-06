package ru.restClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.models.coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RestClient {
    public static void main(String[] args) throws IOException {
        int number;

        do {
            System.out.println("Welcome!");
            System.out.println("1. Get the whole list");
            System.out.println("2. Get by id");
            System.out.println("3. Create a coffeeMachine");
            System.out.println("4. Update a coffeeMachine");
            System.out.println("5. Delete a coffeeMachine");
            System.out.println("6. Exit");
            System.out.print("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(reader.readLine());

            switch (number){

                case 1:
                    List returnAllCoffee = returnAllCoffeeMachine();
                    for (Object list: returnAllCoffee) {
                        System.out.println(list);
                    }
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    int number1 = Integer.parseInt(reader.readLine());
                    String returnCoffee = returnCoffeeMachine(number1);
                    System.out.println(returnCoffee);
                    break;
                case 3:
                    createCoffeeMachine();
                    returnAllCoffeeMachine();
                    break;
                case 4:
                    System.out.print("Enter id: ");
                    int number2 = Integer.parseInt(reader.readLine());
                    updateCoffeeMachine(number2);
                    returnCoffeeMachine(number2);
                    break;
                case 5:
                    System.out.print("Enter id: ");
                    int number3 = Integer.parseInt(reader.readLine());
                    deleteCoffeeMachine(number3);
                    returnAllCoffeeMachine();
                    break;
                case 6:
                    break;
            }
        } while (number != 6);

    }

    public static String returnCoffeeMachine(int id) {
        RestTemplate restTemplate = new RestTemplate();


        String URL = "http://localhost:8080/coffeeMachine";
        return restTemplate.getForObject(URL + "/{id}", String.class, id);
    }

    public static List returnAllCoffeeMachine() {
        RestTemplate restTemplate = new RestTemplate();

        String URL = "http://localhost:8080/coffeeMachine";
        return restTemplate.getForObject(URL, List.class);
    }

    public static String createCoffeeMachine() {
        RestTemplate restTemplate = new RestTemplate();

        String URL = "http://localhost:8080/coffeeMachine";
        HttpEntity<coffeeMachine> request = new HttpEntity<>(
                new coffeeMachine("latte", "arabica", "soy milk", 0.7,
                        1));
        restTemplate.postForObject(URL, request, String.class);
        
        return "Success";
    }

    public static ResponseEntity<String> updateCoffeeMachine(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:8080/coffeeMachine";

        HttpEntity<coffeeMachine> request =
                new HttpEntity<>(new coffeeMachine("americano", "Brazilian",
                        null, 0.6, 2));

        return restTemplate.exchange(URL + "/{id}", HttpMethod.PUT, request, String.class, id);
    }

    public static void deleteCoffeeMachine(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:8080/coffeeMachine/";

        restTemplate.delete(URL + id);
    }
}
