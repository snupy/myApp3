package ru.malik.myApp3.server.repos.simple;

import ru.malik.myApp3.server.business.types.InvoiceForPayment;

import java.util.Date;
import java.util.List;

/**
 * Created by Малик on 05.11.2014.
 */
public interface InvoiceForPaymentDao extends GenericDao<InvoiceForPayment, Long>{
    List<InvoiceForPayment> findByNumberAndDate(String number, Date date);
}
