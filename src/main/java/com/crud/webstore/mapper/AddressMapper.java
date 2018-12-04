package com.crud.webstore.mapper;

import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto mapToAddressEntity(final AddressEntity addressEntity) {
        return new AddressDto(
                addressEntity.getAddressId(),
                addressEntity.getCity(),
                addressEntity.getCountry(),
                addressEntity.getStreetName(),
                addressEntity.getPostalCode(),
                addressEntity.getType()
        );
    }
}
