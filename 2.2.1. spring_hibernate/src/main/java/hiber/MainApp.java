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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("tesla", 3)));
       userService.add(new User("User3", "Lastname234", "user3@mail.ru", new Car("mazda", 6)));
       userService.add(new User("User346", "Lastname6457", "user5@mail.ru", new Car("nissan", 34)));
       userService.add(new User("User657", "Lastname45reg", "user65@mail.ru", new Car("tesla", 6)));
       userService.add(new User("User456", "Lastnamegdsfg", "user677@mail.ru", new Car("mazda", 2)));
       userService.add(new User("User234", "Lastnamesdfs", "userss@mail.ru", new Car("audi", 44)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Auto Model = "+user.getCarModel());
         System.out.println("Auto Series = "+user.getCarSeries());
         System.out.println();
      }


        Car findCar = new Car("tesla", 98);
        userService.getUserByCar(findCar);


      context.close();
   }
}
