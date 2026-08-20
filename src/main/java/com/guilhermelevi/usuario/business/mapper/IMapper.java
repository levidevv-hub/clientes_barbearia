package com.guilhermelevi.usuario.business.mapper;

import com.guilhermelevi.usuario.business.dto.ClienteDTO;
import com.guilhermelevi.usuario.infrastructure.entity.ClienteEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface IMapper {

    ClienteDTO paraDto(ClienteEntity entity);

    ClienteEntity paraEntity(ClienteDTO clienteDTO);

}
