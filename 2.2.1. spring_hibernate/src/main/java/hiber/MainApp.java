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

      userService.add(new User("Андрей", "Давыдов", "andrytate@mail.ru", new Car("tesla", 3)));
       userService.add(new User("Олег", "Газманов", "olezha44@mail.ru", new Car("mazda", 6)));
       userService.add(new User("Игорь", "Иванченко", "ivanchay@mail.ru", new Car("nissan", 34)));
       userService.add(new User("Валентин", "Потеряшка", "valentin_poteryanny@mail.ru", new Car("tesla", 6)));
       userService.add(new User("Артур", "Мастермечников", "artur_the_king@mail.ru", new Car("mazda", 2)));
       userService.add(new User("Арсен", "Чеченский", "userss@mail.ru", new Car("audi", 44)));


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


        Car lostcar = new Car("tesla", 3);
        if (userService.findUserByCar(lostcar) == null) { // Обработка ожидаемого null, чтобы вывести более понятную фразу :-)
            System.out.println("\n\n\n\nВладелец машины не найден\n\n\n\n");
        } else {
            System.out.println("\n\n\n\nПоиск владельца машины: " + userService.findUserByCar(lostcar) + "\n\n\n\n");
        }


        context.close();
   }
}
