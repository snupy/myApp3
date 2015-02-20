package ru.malik.myApp3.server.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.InvoiceForPayment;
import ru.malik.myApp3.server.business.types.Supplier;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class InvoiceForPaymentServiceImplTest {

    public static final String INVOICE_FOR_PAYMENT_NUMBER_NEW = "2213/2323";
    public static final String INVOICE_FOR_PAYMENT_NUMBER_UPDATE = "22ss3/s323";
    public static final Date INVOICE_FOR_PAYMENT_DATE_NEW;
    public static final Date INVOICE_FOR_PAYMENT_DATE_UPDATE;


    static {
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

        Date dateNew, dateUpdate;
        try {
            dateNew = dateFormat.parse("01.01.2001");
        } catch (ParseException e) {
            dateNew = new Date();
            e.printStackTrace();
        }
        try {
            dateUpdate = dateFormat.parse("01.01.2010");
        } catch (ParseException e) {
            dateUpdate = new Date();
            e.printStackTrace();
        }
        INVOICE_FOR_PAYMENT_DATE_NEW = dateNew;
        INVOICE_FOR_PAYMENT_DATE_UPDATE = dateUpdate;
    }

    @Autowired
    InvoiceForPaymentService service;

    @Autowired
    SupplierService supplierService;
    Supplier supplier;

    @Before
    public void setUpSupplier() {
        supplier = new Supplier();
        supplierService.save(supplier);
    }

    @After
    public void tearDownSupplier() {
        supplierService.delete(supplier);
    }


    @Test
    public void testSave() throws Exception {
        InvoiceForPayment invoiceForPayment = new InvoiceForPayment();

        invoiceForPayment.setSupplier(supplier);
        service.save(invoiceForPayment);
        assertNotNull("Ошибка записи InvoiceForPayment в БД", service.findById(invoiceForPayment.getId()));

        service.delete(invoiceForPayment);
    }

    @Test
    public void testUpdate() throws Exception {
        InvoiceForPayment invoiceForPayment = new InvoiceForPayment();

        invoiceForPayment.setSupplier(supplier);

        invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_NEW);
        invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_NEW);

        service.save(invoiceForPayment);
        invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_UPDATE);
        invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_UPDATE);
        service.update(invoiceForPayment);
        invoiceForPayment = service.findById(invoiceForPayment.getId());
        assertTrue("Ошибка обновления invoiceForPayment в БД", INVOICE_FOR_PAYMENT_NUMBER_UPDATE.equals(invoiceForPayment.getNumber()) && INVOICE_FOR_PAYMENT_DATE_UPDATE.equals(invoiceForPayment.getDate()));

        service.delete(invoiceForPayment);
    }

    @Test
    public void testSaveOrUpdate() throws Exception {

        InvoiceForPayment invoiceForPayment = new InvoiceForPayment();

        invoiceForPayment.setSupplier(supplier);

        invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_NEW);
        invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_NEW);

        service.saveOrUpdate(invoiceForPayment);
        assertNotNull("Ошибка обновления invoiceForPayment в БД", service.findById(invoiceForPayment.getId()));

        invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_UPDATE);
        invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_UPDATE);
        service.saveOrUpdate(invoiceForPayment);
        invoiceForPayment = service.findById(invoiceForPayment.getId());
        assertTrue("Ошибка обновления invoiceForPayment в БД", INVOICE_FOR_PAYMENT_NUMBER_UPDATE.equals(invoiceForPayment.getNumber()) && INVOICE_FOR_PAYMENT_DATE_UPDATE.equals(invoiceForPayment.getDate()));

        service.delete(invoiceForPayment);

    }

    @Test
    public void testGetAll() throws Exception {

        int countBef = service.getAll().size();

        for (int i = 0; i < 100; i++) {
            InvoiceForPayment invoiceForPayment = new InvoiceForPayment();
            invoiceForPayment.setSupplier(supplier);
            invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_NEW);
            invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_NEW);

            service.save(invoiceForPayment);
        }

        List<InvoiceForPayment> list = service.getAll();
        int countAft = list.size();

        assertTrue("Ошибка получения всего списка InvoiceForPayment", countAft - countBef == 100);

        for (int i = list.size() - 1; i >= 0; i--) {
            InvoiceForPayment invoiceForPayment = list.get(i);
            if (INVOICE_FOR_PAYMENT_NUMBER_NEW.equals(invoiceForPayment.getNumber()) && INVOICE_FOR_PAYMENT_DATE_NEW.equals(invoiceForPayment.getDate())) {
                service.delete(invoiceForPayment);
            }
        }
    }

    @Test
    public void testFindById() throws Exception {
        InvoiceForPayment invoiceForPayment = new InvoiceForPayment();

        invoiceForPayment.setSupplier(supplier);
        service.save(invoiceForPayment);
        assertNotNull("Ошибка поиска InvoiceForPayment в БД", service.findById(invoiceForPayment.getId()));

        service.delete(invoiceForPayment);
    }

    @Test
    public void testDelete() throws Exception {
        InvoiceForPayment invoiceForPayment = new InvoiceForPayment();

        invoiceForPayment.setSupplier(supplier);
        service.save(invoiceForPayment);
        assertNotNull("Ошибка создания/поиска InvoiceForPayment в БД", service.findById(invoiceForPayment.getId()));

        service.delete(invoiceForPayment);
        assertNull("Ошибка удаления InvoiceForPayment в БД", service.findById(invoiceForPayment.getId()));
    }

    @Test
    public void testDeleteAll() throws Exception {
        int countBef = service.getAll().size();
        List<InvoiceForPayment> list = new ArrayList<InvoiceForPayment>();

        for (int i = 0; i < 100; i++) {
            InvoiceForPayment invoiceForPayment = new InvoiceForPayment();
            invoiceForPayment.setSupplier(supplier);
            invoiceForPayment.setNumber(INVOICE_FOR_PAYMENT_NUMBER_NEW);
            invoiceForPayment.setDate(INVOICE_FOR_PAYMENT_DATE_NEW);

            service.save(invoiceForPayment);
            list.add(invoiceForPayment);
        }
        int countAft = service.getAll().size();
        assertTrue("Ошибка добавления InvoiceForPayment в БД", countAft-countBef==100);

        service.deleteAll(list);

        assertTrue("Ошибка удаления InvoiceForPayment в БД", service.getAll().size()==countBef);
    }
}