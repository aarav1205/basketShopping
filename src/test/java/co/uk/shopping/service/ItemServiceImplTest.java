package co.uk.shopping.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {
    private ItemServiceImpl itemService;
    private final double epsilon = 0.01;
    @BeforeEach
    void setUp() {
        itemService = new ItemServiceImpl();
    }

    @AfterEach
    void tearDown() {
        itemService = null;
    }

    @DisplayName("calculate Total Price 1 Apple , 1 Banana, 2 Melons , 3 Limes")
    @Test
    void calculateTotalPriceTest() {
        List<String> cart = List.of("Apple","Banana","Melon","Melon","Lime","Lime","Lime");
        double result = itemService.calculateTotalPrice(cart);
        assertEquals(1.35,result,epsilon);
    }

    @DisplayName("calculate Total Price 1 Apple , 1 Banana, 1 Melons , 1 Limes")
    @Test
    void calculateTotalPriceTest2() {
        List<String> cart = List.of("Apple","Banana","Melon","Lime");
        double result = itemService.calculateTotalPrice(cart);
        assertEquals(1.20,result,epsilon);
    }

    @DisplayName("calculate Total Price 1 Apple , 1 Banana, 3 Melons , 2 Limes")
    @Test
    void calculateTotalPriceTest3() {
        List<String> cart = List.of("Apple","Banana","Melon","Melon","Melon","Lime","Lime");
        double result = itemService.calculateTotalPrice(cart);
        assertEquals(1.85,result,epsilon);
    }
}