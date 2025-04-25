package ex01;

import lombok.Data;
import model.Product;
import model.ProductOption;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetailDTO {
    private Integer productId;

    List<ProductOptionDTO> productOptions;

    @Data
    public class ProductOptionDTO {
        private Integer optionId;
        private String optionName;
        private int price;
        private int qty;

        public ProductOptionDTO(ProductOption productOption) {
            this.optionId = productOption.getId();
            this.optionName = productOption.getName();
            this.price = productOption.getPrice();
            this.qty = productOption.getQty();
        }
    }

    public ProductDetailDTO(Product product, List<ProductOption> productOptions) {
        this.productId = product.getId();
        List<ProductOptionDTO> productOptionDTOList = new ArrayList<>();
        for (ProductOption productOption : productOptions) {
            ProductOptionDTO productOptionDTO = new ProductOptionDTO(productOption);
            productOptionDTOList.add(productOptionDTO);
        }
        this.productOptions = productOptionDTOList;
    }
}
