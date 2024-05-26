package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Item> createList(Item... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyStatement() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,400));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex=assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("juice","0a34",30,0.2f)),400));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        ex=assertThrows(RuntimeException.class,
                ()->SILab2.checkCart(createList(new Item("milk",null,50,0.5f)),400));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertTrue(SILab2.checkCart(createList(new Item("","0125",350,0.1f)),400));
        assertFalse(SILab2.checkCart(createList(new Item("chips","0268",5000,0.0f)),400));

    }

    @Test
    void everyBranch(){

        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,400));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex=assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("juice","0a34",30,0.2f)),400));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        ex=assertThrows(RuntimeException.class,
                ()->SILab2.checkCart(createList(new Item("milk",null,50,0.5f)),400));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertTrue(SILab2.checkCart(createList(new Item("","0125",350,0.1f)),400));
        assertFalse(SILab2.checkCart(createList(new Item("chips","0268",5000,0.0f)),400));
    }

    @Test
    void multipleConditions() {
        assertTrue(SILab2.checkCart(createList(new Item("", "0123", 350, 0.1F)), 400));
        assertFalse(SILab2.checkCart(createList(new Item("", "1234", 400, 0.5F)), 100));
        assertFalse(SILab2.checkCart(createList(new Item("", "", 360, 0.0F)), 200));
        assertFalse(SILab2.checkCart(createList(new Item("", "", 250, 0.1F)), 10));

    }

}
