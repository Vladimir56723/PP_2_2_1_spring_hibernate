package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);


        userService.add(new User("User80", "Lastname1", "user1@mail.ru", new Car(23, "A")));
        userService.add(new User("User20", "Lastname2", "user2@mail.ru", new Car(85, "B")));
        userService.add(new User("User36", "Lastname3", "user3@mail.ru", new Car(96, "C")));
        userService.add(new User("User455", "Lastname4", "user4@mail.ru", new Car(41, "D")));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getCar());
            System.out.println();
        }

// pom.xml поменчл все до последней версии перед пушем все пораснело вернул с проверки переделал под
     //   старую версию сейчас вроде работает  (5 вер -persistence, а в 6вер уже какая то jakarta)
        userService.getUser();
        List<User> usersCar = userService.getUser();
        for (User user : usersCar) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());

            System.out.println();
        }

        context.close();
    }
}
