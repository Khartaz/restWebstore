package com.crud.webstore.service;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.dto.UserDto;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestSuite {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserEntity userEntity;
    @Mock
    private UserMapper mapper;
    @Mock
    private UserRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        //Given
        when(userEntity.getFirstName()).thenReturn("Tom");
        when(userEntity.getLastName()).thenReturn("Tom2");
        when(userEntity.getId()).thenReturn(1L);

        when(repository.save(userEntity)).thenReturn(userEntity);

        UserDto userDto = new UserDto();
        userDto.setFirstName("Tom");
        userDto.setLastName("Tom2");

        UserEntity result = repository.save(mapper.mapToUserEntity(userDto));

        Assert.assertNotNull(result);
        Assert.assertEquals(userDto.getFirstName(), result.getFirstName());
        Assert.assertEquals(userDto.getLastName(), result.getLastName());
    }


    @Test
    public void testGetUserByUserId() {
        //Given

    }

}