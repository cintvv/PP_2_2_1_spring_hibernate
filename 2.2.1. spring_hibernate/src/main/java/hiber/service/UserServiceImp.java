package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

    @Transactional(readOnly = true)
    @Override
    public void getUserByCar(Car car) {
        List<User> users = userDao.listUsers();
        for (User user : users) {
            if (user.getCarModel().equals(car.getModel()) & user.getCarSeries() == car.getSeries()) {
                System.out.println("\n\n\n\nХозяин машины " + car.getModel()
                        + " серии " + car.getSeries() + " - "
                        + user.getFirstName() + " "
                        + user.getLastName() + "\n\n\n\n");
            }
        }
    }


}
