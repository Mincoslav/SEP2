package domain;

public class ProductCategoryTest {

    public static void main(String[] args) {
        Categories categories = new Categories(3, "Shoes");
        Product product= new Product("xx","url", 12,1,false,"text", 0);


        categories.addProduct(product);

        System.out.println(categories.toString());
        System.out.println(categories.size());
        System.out.println("X");

        categories.removeProduct(product);

        System.out.println("X2");
        System.out.println(categories.size());
        System.out.println(categories.toString());
    }
}
