package com.ticketease.ticket_service.mapper;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public <T> T mapToEntity(Object dto, Class<T> entityClass) {
        return objectMapper.convertValue(dto, entityClass);
    }
}


