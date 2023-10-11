package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.shop.Product;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(23, "Bag", 20_000);
    Product product2 = new Product(47, "Jacket", 33_000);
    Product product3 = new Product(82, "Hat", 544);
    Product product4 = new Product(71, "Dress", 12_000);

    @BeforeEach
    public void setup() {
        repo.add(product1, 23);
        repo.add(product2, 47);
        repo.add(product3, 82);
    }

    @Test
    public void notShouldFindProduct() {
        int id = 45;

        Product expected = null;
        Product actual = repo.findById(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindCorrectProduct() {
        int id = 82;

        Product expected = product3;
        Product actual = repo.findById(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {

        repo.remove(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrows() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(1000);
        });
    }

    @Test
    public void shouldAddNewProduct() {

        repo.add(product4, 71);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowsAddProduct() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product1, 23);
        });
    }

}