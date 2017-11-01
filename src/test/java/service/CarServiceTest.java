package service;

import entity.Car;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CarServiceTest {
    CarService service = new CarService();
    Car car1 = new Car();
    @Test
    public void add() throws Exception {
        //Создаем автомобиль для записи в БД
        car1.setName("Ferrari");
        car1.setCost(1000000);
        car1.setReleaseDate(new Date());
        //Записываем его в БД
        Car car = service.add(car1);
        System.out.println(car);
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Ferrari");
        car1.setCost(100000);
        car1.setReleaseDate(new Date());

        //Записываем его в БД
        Car car = service.add(car1);

        //Удаляем его с БД
        service.delete(car.getId());
    }

    @Test
    public void update() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Lamborghini");
        car1.setCost(5000000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        car1 = service.add(car1);

        car1.setCost(0);

        //Обновляем
        service.update(car1);

        //Получаем обновленную запись
        Car car2 = service.get(car1.getId());
        System.out.println(car2);
    }

    @Test
    public void getAll() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Lexus");
        car1.setCost(300000);
        car1.setReleaseDate(new Date());

        //Создаем автомобиль для записи в БД
        Car car2 = new Car();
        car2.setName("Fiat");
        car2.setCost(20000);
        car2.setReleaseDate(new Date());

        //Создаем автомобиль для записи в БД
        Car car3 = new Car();
        car3.setName("Porsche");
        car3.setCost(458000);
        car3.setReleaseDate(new Date());

        //Сохраняем все авто
        service.add(car1);
        service.add(car2);
        service.add(car3);

        //Получаем все авто с БД
        List<Car> cars = service.getAll();

        //Выводим полученый список авто
        for(Car c : cars){
            System.out.println(c);
        }
    }

}