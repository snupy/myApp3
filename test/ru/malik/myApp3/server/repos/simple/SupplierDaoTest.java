package ru.malik.myApp3.server.repos.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.Supplier;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class SupplierDaoTest {
    @Autowired
    SupplierDao supplierDao;

    @Test
    public void testInjectSuppierDao() {
        assertNotNull("Ошибка инъектирования SuppierDao=" + supplierDao, supplierDao);
    }

    @Test
    public void testCreateSupplier() {
        Supplier supplierNew = new Supplier();
        supplierNew.setName("Test123");
        supplierDao.create(supplierNew);

        Supplier supplierOld = supplierDao.findByName("Test123").get(0);

        assertNotNull("Ошибка создания Suppier=" + supplierOld, supplierOld);
    }

    @Test
    public void testUpdateSupplier() {
        Supplier supplierNew = new Supplier();
        supplierNew.setName("Test123");
        supplierDao.create(supplierNew);

        supplierNew = supplierDao.findByName("Test123").get(0);
        supplierNew.setName("1234");
        supplierDao.update(supplierNew);

        Supplier supplierOld = supplierDao.findByName("1234").get(0);

        assertNotNull("Ошибка изменения Suppier=" + supplierOld, supplierOld);
    }

    @Test
    public void testDeleteSupplier() {
        Supplier supplierNew = new Supplier();
        supplierNew.setName("Test123");
        supplierDao.create(supplierNew);

        for (Supplier supplier : supplierDao.findByName("Test123")) {
            supplierDao.delete(supplier);
        }

        assertTrue("Ошибка удаления Suppier=" + supplierNew, supplierDao.findByName("Test123").size() == 0);
    }

    @Test
    public void testReadSupplier() {
        Supplier supplierNew = new Supplier();
        supplierNew.setName("Test123");
        supplierDao.create(supplierNew);

        Supplier supplierOld = supplierDao.read(supplierNew.getId());

        assertNotNull("Ошибка чтения Suppier=" + supplierOld, supplierOld);
    }
}