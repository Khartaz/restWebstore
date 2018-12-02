package com.crud.webstore.domain;

import com.crud.webstore.repository.AddressRepository;
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
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testUserEntitySave() {
        //Given
        UserEntity userEntity = new UserEntity("test1", "test1", "test1", "test1", "test1");
        //When
        userRepository.save(userEntity);
        //Then
        long id = userEntity.getId();
        UserEntity userEntity1 = userRepository.findOne(id);
        Assert.assertEquals(id, userEntity1.getId());
        //CleanUp
        userRepository.delete(id);
    }

    @Test
    public void testUserEntitySaveWithAddresses() {
        //Given
        UserEntity userEntity = new UserEntity("test2", "test2", "test2", "test2", "test2");
        userRepository.save(userEntity);

        AddressEntity addressEntity = new AddressEntity("test2", "test2", "test2", "test2", "test2", "test2");
        userEntity.getAddressEntityList().add(addressEntity);
        //When
        addressRepository.save(addressEntity);
        long id = addressEntity.getId();
        //Then
        Assert.assertEquals(1, id);


    }
}
