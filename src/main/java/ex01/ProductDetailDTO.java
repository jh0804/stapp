package ex01;

import lombok.Data;
import model.Product;
import model.ProductOption;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetailDTO {
    private Integer productId;
    private String productName;
    // 필드에서 리스트를 new 하면 생성자 내부에서 new할 필요 없음
    // 필드명에는 dto 안붙이는게 좋다.
    List<ProductOptionDTO> options = new ArrayList<>();

    public ProductDetailDTO(Product p, List<ProductOption> options) {
        this.productId = p.getId();
        this.productName = p.getName();
        for (ProductOption op : options) {
            this.options.add(new ProductOptionDTO(op));
        }
    }

    @Data
    public class ProductOptionDTO {
        private int optionId;
        private String optionName;
        private int optionPrice;
        private int optionQty;

        public ProductOptionDTO(ProductOption op) {
            this.optionId = op.getId();
            this.optionName = op.getName();
            this.optionPrice = op.getPrice();
            this.optionQty = op.getQty();
        }
    }
}