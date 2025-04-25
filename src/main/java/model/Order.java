package model;

import lombok.Builder;
import lombok.Data;

//주문1 (주문번호를 들고 있음)
@Data
public class Order {
    private int id;

    @Builder
    public Order(int id) {
        this.id = id;
    }
}