package me.teelkenjr.databasespringboot.mappers.impl;

import me.teelkenjr.databasespringboot.domain.dto.AuthorDto;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import me.teelkenjr.databasespringboot.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class AuthorMapper implements Mapper<AuthorEntity, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
