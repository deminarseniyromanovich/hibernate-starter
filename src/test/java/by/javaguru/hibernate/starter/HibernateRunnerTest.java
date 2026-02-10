package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.User;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HibernateRunnerTest {

    @Test
    public void testHibernateApi() {
        var user = User.builder()
                .username("ivan@mail.ru")
                .firstname("ivan")
                .lastname("ivanov")
                .birthDate(LocalDate.of(2000, 01, 01))
                .age(26)
                .build();
        var sql = """
                insert into
                %s
                (%s)
                values 
                %s
                """;

        var tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(table -> table.schema() + "." + table.name())
                .orElse(user.getClass().getName());


    }

}