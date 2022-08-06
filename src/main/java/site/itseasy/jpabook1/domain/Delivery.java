package site.itseasy.jpabook1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Delivery {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Setter
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(STRING)
    private DeliveryStatus status;
}
