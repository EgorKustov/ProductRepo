import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTests {

    @Test
    void testRemoveExistingElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(24, "Bag", 300);
        Product product2 = new Product(14, "Milk", 120);
        Product product3 = new Product(52, "Meat", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(14);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testRemoveNonExistingElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(24, "Bag", 300);
        Product product2 = new Product(14, "Milk", 120);
        Product product3 = new Product(52, "Meat", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(26)
        );

    }
}

