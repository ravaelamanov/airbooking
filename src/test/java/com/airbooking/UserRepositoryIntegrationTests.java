package com.airbooking;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        user = new User();
        user.setUsername("name");
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
        assertThat(userList.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(userList.get(0).getEmail()).isEqualTo(user.getEmail());
        assertThat(userList.get(0).getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void givenUserId_whenFindById_thenRetrievedMatchesPersisted() {
        //given
        User persistedUser = testEntityManager.persistAndFlush(user);

        //when
        User retrievedUser = userRepository.findById(persistedUser.getId()).get();

        //then
        assertThat(retrievedUser.getUsername()).isEqualTo(persistedUser.getUsername());
        assertThat(retrievedUser.getEmail()).isEqualTo(persistedUser.getEmail());
        assertThat(retrievedUser.getPassword()).isEqualTo(persistedUser.getPassword());
    }

    @Test
    public void givenUser_whenSaveUser_thenRetrievedMatchesPersisted() {
        //given
        //when
        User persistedUser = userRepository.save(user);
        //then
        User retrievedUser = testEntityManager.find(user.getClass(), user.getId());
        assertThat(retrievedUser.getUsername()).isEqualTo(persistedUser.getUsername());
        assertThat(retrievedUser.getEmail()).isEqualTo(persistedUser.getEmail());
        assertThat(retrievedUser.getPassword()).isEqualTo(persistedUser.getPassword());
    }

    @Test
    public void givenPersistedUser_whenUpdateUser_thenRetrievedUserMatchesUpdatedUser() {
        //given
        User persistedUser = testEntityManager.persistAndFlush(user);
        //when
        persistedUser.setUsername("updatedUserName");
        persistedUser.setPassword("updatedPassword");
        persistedUser.setEmail("udpatedEmail@gmail.com");
        User updatedUser = userRepository.save(persistedUser);
        //then
        User retrievedUser = testEntityManager.find(updatedUser.getClass(), updatedUser.getId());
        assertThat(updatedUser.getId()).isEqualTo(retrievedUser.getId());
        assertThat(updatedUser.getUsername()).isEqualTo(retrievedUser.getUsername());
        assertThat(updatedUser.getEmail()).isEqualTo(retrievedUser.getEmail());
        assertThat(updatedUser.getPassword()).isEqualTo(retrievedUser.getPassword());
    }

    @Test
    public void givenPersistedUserId_whenDeleteById_thenFindByIdIsNull() {
        //given
        User persistedUser = testEntityManager.persist(user);
        //when
        userRepository.deleteById(user.getId());
        //then
        assertThat(testEntityManager.find(user.getClass(), persistedUser.getId())).isNull();
    }

}
