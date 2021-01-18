package com.airbooking;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//TODO Add test methods for all the UserRepository methods
//FIXME @Before annotation doesn't work

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp(){
        User user = new User();
        user.setUserName("name");
        user.setEmail("user@gmail.com");
        user.setPassword("pass");
    }

    @Test
    public void givenAllUsers_whenFindAll_thenReturnAllUsers() {
        //given
        testEntityManager.persist(user);
        testEntityManager.flush();

        //when
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);

        //then
        assertThat(userList.size()).isEqualTo(1);
        assertThat(userList.get(0).getUserName()).isEqualTo(user.getUserName());
    }
}
