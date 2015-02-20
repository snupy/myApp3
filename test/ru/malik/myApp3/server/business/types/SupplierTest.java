package ru.malik.myApp3.server.business.types;

import org.junit.Test;

import static org.junit.Assert.*;

public class SupplierTest {
    @Test
    public void TestSupplierCreate(){
        Supplier supplier = new Supplier();
        assertNotNull(supplier);
    }

}