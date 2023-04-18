package me.day06.objectarrays;


public class Main {
    static Members members = Members.getInstance();
    static ShoppingItems shoppingItems = ShoppingItems.getInstance();
    public static void main(String[] args) {

        // members test
        System.out.println("<<initialize members>>");
        members.init();
        System.out.println(members);
        System.out.println();

        System.out.println("<<add eunbin1 twice>>");
        members.add(new Member("eunbin1", "eunbin1234"));
        members.add(new Member("eunbin1", "eunbin1234"));
        System.out.println(members);
        System.out.println();

        System.out.println("<<insert eunbin2 twice>>");
        members.insert(new Member("eunbin2", "eunbin1234"));
        members.insert(new Member("eunbin2", "eunbin1234"));
        System.out.println(members);
        System.out.println();

        // shopping items test
        System.out.println("<<initialize shoppingItems>>");
        shoppingItems.init();
        System.out.println(shoppingItems);
        System.out.println();

        ////////////////////////////////////////////////////////
        // case 1: members(0) add shoppingItem(1) in shopping cart.
        members.get(0).cart(shoppingItems.get(1));
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println(members.get(0).getOrders());
        System.out.println();

        // case 2: members(0) order shopping items in shopping cart.
        members.get(0).order("경기도 화성시 ...");
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println(members.get(0).getOrders());
        System.out.println();

        // case 3: members(0) order shopping item directly.
        members.get(0).order(shoppingItems.get(5), 2, "서울특별시 강남구 ...");
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println(members.get(0).getOrders());
        System.out.println();

        /////////////////////////////////////////////////////////

        // 문제 1: 로그인 기능
        System.out.println("<<<문제 1>>>");
        System.out.println(members.login("sally", "sally1234"));
        System.out.println(members.login("eunbin1", "eunbin1"));
        System.out.println(members.login("eunbin1", "eunbin1234"));
        System.out.println();

        // 문제 2: 회원정보 수정 기능
        System.out.println("<<<문제 2>>>");
        System.out.println(members.update(new Member("sally")));
        System.out.println(members.update(new Member("eunbin1", "eunbin1")));
        System.out.println(members.update(
                new Member(
                        "eunbin1", "eunbin1",
                        "eunbin544@gmail.com",
                        "서울특별시 동작구 ...")));
        System.out.println();

        // 문제 3: 상품 이름을 통해 상품을 검색하는 기능
        System.out.println("<<<문제 3>>>");
        System.out.println(shoppingItems.searchByItemName("a"));
        System.out.println(shoppingItems.searchByItemName("zzzz"));
        System.out.println();

        // 문제 4: 특정 카테고리의 상품을 검색하는 기능
        System.out.println("<<<문제 4>>>");
        System.out.println(shoppingItems.searchByCategory(ShoppingItem.Category.INNER));
        System.out.println();

        // 문제 5: 상품가격 범위를 설정하여 상품을 검색하는 기능
        System.out.println("<<<문제 5>>>");
        System.out.println(shoppingItems.searchByPriceRange(5000, 4000));
        System.out.println(shoppingItems.searchByPriceRange(3000, 5000));
        System.out.println();

        // 문제 6: 맴버가 상품을 장바구니에 추가하는 기능
        System.out.println("<<<문제 6>>>");
        members.get(0).cart(shoppingItems.get(0));
        members.get(0).cart(shoppingItems.get(1));
        members.get(0).cart(shoppingItems.get(2));
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println();

        // 문제 7: 멤버가 상품을 장바구니에서 삭제하는 기능
        System.out.println("<<<문제 7>>>");
        members.get(0).cancelCart(members.get(0).getShoppingCarts().get(0).getShoppingCartNo());
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println();

        // 문제 8: 멤버가 장바구니에 있는 상품을 주문하는 기능
        System.out.println("<<<문제 8>>>");

        // case 1: members(0) order shopping items in shopping cart.
        System.out.println("case 1");
        members.get(0).order("대전광역시 서구 ...");
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println(members.get(0).getOrders());
        System.out.println();

        // case 2: members(0) order shopping item directly.
        System.out.println("case 2");
        members.get(0).order(shoppingItems.get(5), 2, "경기도 고양시 ...");
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println(members.get(0).getOrders());
        System.out.println();


        // 문제 9: 장바구니에 있는 상품들을 장바구니에 등록한 시간 순서대로 정렬하는 기능
        System.out.println("<<<문제 9>>>");
        for (int i = shoppingItems.size()-1; i >= 0; i--) {
            members.get(0).getShoppingCarts().add(new ShoppingCart(shoppingItems.get(i)));
        }

        System.out.println(members.get(0).getShoppingCarts());
        members.get(0).getShoppingCarts().sortByTime(ShoppingCarts.Sort.DESC);
        System.out.println(members.get(0).getShoppingCarts());
        System.out.println();

        // 문제 10: 주문상태에 따라 주문내역을 그룹핑하는 기능
        System.out.println("<<<문제 10>>>");
        for (int i = 0; i < Order.Status.values().length; i++) {
            System.out.println(members.get(0).getOrders().groupByStatus(Order.Status.values()[i]));
            System.out.println();
        }
    }
}
