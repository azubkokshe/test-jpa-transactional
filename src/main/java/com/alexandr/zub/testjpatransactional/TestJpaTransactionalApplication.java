package com.alexandr.zub.testjpatransactional;

import com.alexandr.zub.testjpatransactional.model.Sex;
import com.alexandr.zub.testjpatransactional.model.User;
import com.alexandr.zub.testjpatransactional.repo.UserRepo;
import com.alexandr.zub.testjpatransactional.service.Worker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@SpringBootApplication
public class TestJpaTransactionalApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TestJpaTransactionalApplication.class, args);
    }

    @Autowired
    @Qualifier("workerLock")
    Worker w1;

    @Autowired
    @Qualifier("workerNotLock")
    Worker w2;

    @Override
    public void run(String... args) throws Exception {
//        userRepo.save(User.builder().age(10).name("Alex").sex(Sex.MALE).build());
//        userRepo.save(User.builder().age(20).name("Michael").sex(Sex.MALE).build());
//
//        User user = userRepo.findUserByName("Alex");
//
//        if (user != null) {
//            user.setAge(11);
//
//            Thread.sleep(10000);
//
//            userRepo.save(user);
//        }
//
        w1.start();
        w2.start();

    }
}
