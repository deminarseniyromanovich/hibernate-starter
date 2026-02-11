package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        //подключаем конфигурацию
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(User.class);

        //создаем конвеер по созданию сессий
        //и с помощью него делаем сессию
        try (var sessionFactory = configuration.buildSessionFactory();
                var session = sessionFactory.openSession()) {
            //начинаем сессию
            session.beginTransaction();

            //добавляем пользователя в таблицу
            session.persist(User.builder()
                            .username("ivan@mail.ru")
                            .firstname("ivan")
                            .lastname("ivanov")
                            .birthDate(LocalDate.of(2000, 01, 01))
                            .age(26)
                    .build());

            //заканчиваем сессию
            session.getTransaction().commit();
        }

    }
}
