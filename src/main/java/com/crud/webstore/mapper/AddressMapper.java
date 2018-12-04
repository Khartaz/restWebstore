package com.crud.webstore.mapper;

import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto mapToAddressDto(final AddressEntity addressEntity) {
        return new AddressDto(
                addressEntity.getAddressId(),
                addressEntity.getCity(),
                addressEntity.getCountry(),
                addressEntity.getStreetName(),
                addressEntity.getPostalCode(),
                addressEntity.getType()
        );
    }

    public AddressEntity mapToAddressEntity(final AddressDto addressDto) {
        return new AddressEntity(
                addressDto.getAddressId(),
                addressDto.getCity(),
                addressDto.getCountry(),
                addressDto.getStreetName(),
                addressDto.getPostalCode(),
                addressDto.getType()
        );
    }
}