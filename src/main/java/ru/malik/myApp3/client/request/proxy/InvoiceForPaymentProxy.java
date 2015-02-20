package ru.malik.myApp3.client.request.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.malik.myApp3.server.business.types.InvoiceForPayment;
import ru.malik.myApp3.server.business.types.InvoiceForPaymentLocator;

import java.util.Date;

/**
 * Created by Малик on 14.12.2014.
 */
@ProxyFor(value = InvoiceForPayment.class, locator = InvoiceForPaymentLocator.class)
public interface InvoiceForPaymentProxy extends EntityProxy {

    public Long getId();

    public void setId(Long id);

    public Date getDate();

    public void setDate(Date date);

    public String getNumber();

    public void setNumber(String number);

    public SupplierProxy getSupplier();

    public void setSupplier(SupplierProxy supplier);

    public Double getPriceSum();

    public void setPriceSum(Double priceSum);

    public Long getVersion();

    public void setVersion(Long version);
}
