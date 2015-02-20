package ru.malik.myApp3.server.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.Supplier;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class SupplierServiceImplTest {
    @Autowired
    SupplierService supplierService;
    @Test
    public void testSave() throws Exception {
        Supplier sup1 = new Supplier();
        supplierService.save(sup1);
        Supplier sup2 = supplierService.findById(sup1.getId());

        assertNotNull("Ошибка записи Supplier в БД", sup2);
    }

    @Test
    public void testGetAll() throws Exception {
        for (int i = 0; i<100; i++){
            supplierService.save(new Supplier());
        }
        List<Supplier> list = supplierService.getAll();
        assertTrue("Ошибка получения Supplier из БД", list.size()>=100);
    }

    @Test
    public void testFindById() throws Exception {
        Supplier sup1 = new Supplier();
        supplierService.save(sup1);
        Supplier sup2 = supplierService.findById(sup1.getId());

        assertNotNull("Ошибка поиска по Id Supplier в БД", sup2);
    }
}