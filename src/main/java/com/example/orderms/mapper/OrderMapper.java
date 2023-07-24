package com.example.orderms.mapper;


import com.example.orderms.dto.request.OrderRequest;
import com.example.orderms.dto.response.OrderResponse;
import com.example.orderms.model.Order;
import org.mapstruct.Mapper;

/**
 * @author Ashraf on 19-Jul-23
 * @project order
 */

@Mapper(componentModel = "spring")
public interface OrderMapper {
   Order requestToEntity(OrderRequest request);
   OrderResponse entityToResponse(Order order);
}
