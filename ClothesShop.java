public class ClothesShop {

    public static void main(String args[]) {

        System.out.println("------------Category Shirt-------------");
        Shirt Shirt_S = new Shirt("S", 10, 150);
        Shirt Shirt_M = new Shirt("M", 10, 150);
        Shirt Shirt_L = new Shirt("L", 10, 150);
        Shirt Shirt_XL = new Shirt("XL", 10, 150);

        Shirt_S.data();
        Shirt_M.data();
        Shirt_L.data();
        Shirt_XL.data();

        System.out.println("");
        System.out.println("------------Category T-Shirt-----------");
        TShirt TShirt_S = new TShirt("S", 0, 100);
        TShirt TShirt_M = new TShirt("M", 20, 100);
        TShirt TShirt_L = new TShirt("L", 20, 100);
        TShirt TShirt_XL = new TShirt("XL", 20, 100);

        TShirt_S.data();
        TShirt_M.data();
        TShirt_L.data();
        TShirt_XL.data();

        System.out.println("");
        System.out.println("----------Customer Order 1------------");
        Order x1 = new Order();
        x1.PayShirt(Shirt_XL, 10);
        x1.PayShirt(Shirt_L, 5);

        x1.total();

        System.out.println("");
        System.out.println("----------Customer Order 2------------");
        Order x2 = new Order();
        x2.PayShirt(Shirt_XL, 1);
        x2.PayShirt(Shirt_S, 5);
        x2.PayTShirt(TShirt_L, 5);

        x2.total();

        System.out.println("");
        System.out.println("-------------Daily sales--------------");
        int sale = x1.total + x2.total;
        System.out.println("Total sale " + sale + " Bath");
    }
}

class Order {
    String size;
    int num;
    int price;
    int total;

    Order(String s, int n, int p) {
        size = s;
        num = n;
        price = p;
        total = 0;
    }

    Order() {
        total = 0;
    }

    void PayShirt(Shirt s, int x) {

        if (s.num == 0) {
            System.out.println("Shirt size " + s.size + " Out of stock ");
        } else if (x > s.num) {
            System.out.println("Shirt size " + s.size + " Product Not enough");
        } else {
            System.out.println("Shirt size " + s.size + " Number of products: " + x + "\t");
            s.num -= x;
            total += x * s.price;
        }

    }

    void PayTShirt(TShirt t, int x) {

        if (t.num == 0) {
            System.out.println("TShirt size " + t.size + " Out of stock ");
        } else if (x > t.num) {
            System.out.println("TShirt size  " + t.size + " Product Not enough");
        } else {
            System.out.println("TShirt size " + t.size + " Number of products: " + x + "\t");
            t.num -= x;
            total += x * t.price;
        }

    }

    void total() {
        System.out.println("Order Total: " + total + " Bath");
    }

    void data() {
        if (num == 0) {
            System.out.println(size + " Out of stock");
        } else
            System.out.println(size + " Stock: " + num + " Price: " + price + " Bath");
    }
}

class Shirt extends Order {
    Shirt(String s, int n, int p) {
        super(s, n, p);
    }

    void data() {
        System.out.print("Shirt ");
        super.data();
    }
}

class TShirt extends Order {
    TShirt(String s, int n, int p) {
        super(s, n, p);
    }

    void data() {
        System.out.print("TShirt ");
        super.data();
    }
}
