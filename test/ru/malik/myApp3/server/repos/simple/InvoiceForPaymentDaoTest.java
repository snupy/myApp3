package ru.malik.myApp3.server.repos.simple;

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
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class InvoiceForPaymentDaoTest {

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

    private InvoiceForPayment createNewInvoiceForPayment(String number, Date date) {
        InvoiceForPayment invoiceForPaymentNew = new InvoiceForPayment();
        invoiceForPaymentNew.setDate(date);
        invoiceForPaymentNew.setNumber(number);

        {
            Supplier supplierNew = new Supplier();
            supplierNew.setName("Test");

            supplierDao.create(supplierNew);

            invoiceForPaymentNew.setSupplier(supplierNew);
        }

        invoiceForPaymentDao.create(invoiceForPaymentNew);

        return invoiceForPaymentNew;
    }


    @Autowired
    InvoiceForPaymentDao invoiceForPaymentDao;

    @Autowired
    SupplierDao supplierDao;

    @Test
    public void testInjectInvoiceForPaymentDao() {
        assertNotNull(invoiceForPaymentDao);
    }

    @Test
    public void testCreateInvoiceForPayment() {
        InvoiceForPayment invoiceForPaymentNew = createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);

        InvoiceForPayment invoiceForPaymentOld = invoiceForPaymentDao.read(invoiceForPaymentNew.getId());
        assertNotNull("Ошибка добавления InvoiceForPayment в БД=" + invoiceForPaymentNew, invoiceForPaymentOld);
    }

    @Test
    public void testFindByNumberAndDate() {
        int begCount = invoiceForPaymentDao.findByNumberAndDate(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW).size();
        createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);
        createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_UPDATE);
        createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_UPDATE, INVOICE_FOR_PAYMENT_DATE_UPDATE);
        createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_UPDATE, INVOICE_FOR_PAYMENT_DATE_NEW);

        int endCount = invoiceForPaymentDao.findByNumberAndDate(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW).size();
        assertTrue("Ошибка метода FindByNumberAndDate", endCount - begCount == 1);
    }

    @Test
    public void testDeleteInvoiceForPayment(){
        createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);
        List<InvoiceForPayment> invoiceForPayments = invoiceForPaymentDao.findByNumberAndDate(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);
        int begCount = invoiceForPayments.size();
        for(InvoiceForPayment invoiceForPayment: invoiceForPayments){
            invoiceForPaymentDao.delete(invoiceForPayment);
        }

        int endCount = invoiceForPaymentDao.findByNumberAndDate(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW).size();
        assertTrue("Ошибка удаления записи InvoiceForPayment из БД: остаточно записей="+endCount+"; было записей до="+begCount, endCount==0 && endCount<begCount);
    }

    @Test
    public  void testUpdateInvoiceForPayment(){
        InvoiceForPayment invoiceForPaymentNew = createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);
        InvoiceForPayment invoiceForPaymentOld = invoiceForPaymentDao.read(invoiceForPaymentNew.getId());


            Supplier supplierNew = new Supplier();
            supplierNew.setName("TestOld");

            supplierDao.create(supplierNew);

        invoiceForPaymentOld.setSupplier(supplierNew);
        invoiceForPaymentOld.setDate(INVOICE_FOR_PAYMENT_DATE_UPDATE);
        invoiceForPaymentOld.setNumber(INVOICE_FOR_PAYMENT_NUMBER_UPDATE);

        invoiceForPaymentDao.update(invoiceForPaymentOld);

        invoiceForPaymentOld = null;
        invoiceForPaymentOld = invoiceForPaymentDao.read(invoiceForPaymentNew.getId());

        assertTrue("Ошибка при перезаписи InvoiceForPayment в БД. Дата не соответствует", INVOICE_FOR_PAYMENT_DATE_UPDATE.equals(invoiceForPaymentOld.getDate()));
        assertTrue("Ошибка при перезаписи InvoiceForPayment в БД. Номер не соответствует", INVOICE_FOR_PAYMENT_NUMBER_UPDATE.equals(invoiceForPaymentOld.getNumber()));
        assertTrue("Ошибка при перезаписи InvoiceForPayment в БД. Поле supplier не соответствует", supplierNew.equals(invoiceForPaymentOld.getSupplier()));
    }

    @Test
    public  void testReadInvoiceForPayment(){
        InvoiceForPayment invoiceForPaymentNew = createNewInvoiceForPayment(INVOICE_FOR_PAYMENT_NUMBER_NEW, INVOICE_FOR_PAYMENT_DATE_NEW);
        InvoiceForPayment invoiceForPaymentOld = invoiceForPaymentDao.read(invoiceForPaymentNew.getId());
        assertNotNull("Ошибка чтения InvoiceForPayment по id в БД=" + invoiceForPaymentNew, invoiceForPaymentOld);
    }
}