package com.voicecart.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testProductCreation() {
        Product p = new Product("Milk", "milk.jpg");

        assertEquals("Milk", p.name);
        assertEquals("milk.jpg", p.img);
    }

    @Test
    void testProductsArrayNotNull() {
        assertNotNull(App.products);
    }

    @Test
    void testProductsCount() {
        assertEquals(5, App.products.length);
    }

    @Test
    void testCartInitiallyEmpty() {
        App.cart.clear();
        assertEquals(0, App.cart.size());
    }

    @Test
    void testAddToCart() {
        App.cart.clear();

        Product p = new Product("Rice", "rice.jpg");
        App.cart.add(p);

        assertEquals(1, App.cart.size());
        assertEquals("Rice", App.cart.get(0).name);
    }

    @Test
    void testFavoriteInitiallyEmpty() {
        App.fav.clear();
        assertEquals(0, App.fav.size());
    }

    @Test
    void testAddToFavorite() {
        App.fav.clear();

        Product p = new Product("Egg", "egg.jpg");
        App.fav.add(p);

        assertEquals(1, App.fav.size());
        assertEquals("Egg", App.fav.get(0).name);
    }
}