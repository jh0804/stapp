package ex01;

import lombok.Data;
import model.Product;

@Data
public class ProductDTO {
    // 깊은 복사
    private int id;
    private String name;

    // 바꿀 대상을 한꺼번에 통으로 넣는다 -> setter가 아닌 생성자를 써야됨
    // setter는 상태를 변경
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
