package com.crud.webstore.service;

import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.dto.AddressDto;
import com.crud.webstore.mapper.AddressMapper;
import com.crud.webstore.repository.AddressRepository;
import com.crud.webstore.service.impl.UtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;


public class AddressService {
    @Autowired
    private AddressMapper mapper;
    @Autowired
    private UtilsImpl utils;
    @Autowired
    private AddressService service;
    @Autowired
    private AddressRepository repository;

    public AddressEntity save(final AddressDto addressDto) {
        return repository.save(mapper.mapToAddressEntity(addressDto));
    }

    public AddressDto createAddress(AddressDto addressDto) {

        addressDto.setAddressId(utils.generatePublicId(20));

        service.save(addressDto);

        return addressDto;
    }
}
