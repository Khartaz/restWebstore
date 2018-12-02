package com.crud.webstore.domain;

import com.crud.webstore.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressEntityTestSuite {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testUserEntitySave() {
        //Given
        AddressEntity addressEntity = new AddressEntity("test1", "test1", "test1", "test1", "test1", "test");
        //When
        addressRepository.save(addressEntity);
        //Then
        long id = addressEntity.getId();
        AddressEntity resultEntity = addressRepository.findOne(id);
        Assert.assertEquals(id, resultEntity.getId());
    }
}
