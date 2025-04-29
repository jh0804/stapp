package ex02;

import com.google.gson.Gson;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StEx01 {
    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 4, 5); // java에서도 let같은 타입 추론 제공

        Cart c1 = new Cart(1, "바나나", 1000);
        Cart c2 = new Cart(2, "바나나", 1000);
        Cart c3 = new Cart(3, "딸기", 2000);
        Cart c4 = new Cart(4, "사과", 3000);

        var cartList = Arrays.asList(c1, c2, c3, c4);

        // 1. map (가공)
        // 물가에 1, 2, 3, 4, 5 던짐 (전부 *2해서 가공해서 수집)
        var new11 = list.stream().map(i -> i * 2).toList(); //.toList() = 수집
        System.out.println(new11);

        var new12 = list.stream()
                .map(i -> i * 2)
                .filter(i -> i != 10) // 연산 2번 - 2, 4, 6, 8만 true로 리턴돼서 false는 물가에서 사라진다.
                .toList();
        System.out.println(new12);

        // 2. filter (검색, 삭제)
        var new21 = list.stream()
                .filter(i -> i < 3)
                .toList();
        System.out.println(new21);

        // 3. count(개수), sorted(정렬), distinct(중복제거)
        var new31 = list.stream()
                .sorted(Comparator.reverseOrder()) // Comparator.reverseOrder() : 내림차순
                .map(i -> i / 3) // [1, 1, 1, 0, 0]
                .distinct() // 1, 0만 남는다
                .count(); // 배열의 개수
        System.out.println(new31);

        // 4. mapToInt, sum, min, max, average
        var new41 = cartList.stream() // 1. 물가에 던져진 cart 4개
                .mapToInt(cart -> cart.getPrice()) // 2. 물가에 던져진 int 4개
                .max();
        System.out.println(new41);

        // 5. groupBy [key=[c1, c2], key=[c3], key=[c4]]
        // 같은 바나나끼리 묶고 싶음
        var new51 = cartList.stream()
                .collect(Collectors.groupingBy(cart -> cart.getName())) // 이름으로 그룹핑
                .entrySet()
                .stream() // 여기까지는 set 타입
                .map(e -> e.getValue())
                .toList();
        System.out.println(new51);

        Gson gson = new Gson();
        String json = gson.toJson(new51);
        System.out.println(json);


    }

    // 내부 클래스 (메서드 안에 클래스 못 만든다!!)
    @Data
    static class Cart{
        private int id;
        private String name;
        private int price;

        public Cart(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
