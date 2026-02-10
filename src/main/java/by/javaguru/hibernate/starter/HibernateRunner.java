package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(User.class);
        try (var sessionFactory = configuration.buildSessionFactory();
                var session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(User.builder()
                            .username("ivan@mail.ru")
                            .firstname("ivan")
                            .lastname("ivanov")
                            .birthDate(LocalDate.of(2000, 01, 01))
                            .age(26)
                    .build());

            session.getTransaction().commit();
        }

    }
}
