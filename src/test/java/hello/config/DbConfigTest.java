package hello.config;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DbConfigTest {

    @Autowired
    DataSource Datasource;
    @Autowired
    TransactionManager transactionManager;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void beanTest() {
        System.out.println(Datasource);
        System.out.println(transactionManager);
        System.out.println(jdbcTemplate);

        Assertions.assertThat(Datasource.getClass()).isNotNull();
        Assertions.assertThat(transactionManager.getClass()).isNotNull();
        Assertions.assertThat(jdbcTemplate.getClass()).isNotNull();

    }

}