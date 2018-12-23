package com.crud.webstore.service;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.dto.UserDto;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTestSuite {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserEntity userEntity;
    @Autowired
    private UserMapper mapper;
    @Mock
    private UserRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {

    }


    @Test
    public void testGetUserByUserId() {
        //Given


    }

}