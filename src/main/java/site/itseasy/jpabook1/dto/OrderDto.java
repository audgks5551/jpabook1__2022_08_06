package site.itseasy.jpabook1.dto;

import lombok.Getter;
import lombok.Setter;
import site.itseasy.jpabook1.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private MemberDto member;
    private List<OrderItemDto> orderItems;
    private DeliveryDto delivery;
    private LocalDateTime orderDate;
    private OrderStatus status;
}
