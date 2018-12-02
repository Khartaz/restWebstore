package com.crud.webstore.domain;

import com.crud.webstore.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserEntitySave() {
        //Given
        UserEntity userEntity = new UserEntity("test1", "test21", "tes2t", "tes3t", "test4");
        //When
        userRepository.save(userEntity);
        //Then
        long id = userEntity.getId();
        UserEntity userEntity1 = userRepository.findOne(id);
        Assert.assertEquals(id, userEntity1.getId());
        //CleanUp
        userRepository.delete(id);
    }
}
