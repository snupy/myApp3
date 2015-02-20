package ru.malik.myApp3.server.business.types;

import com.google.web.bindery.requestfactory.shared.Locator;

import java.util.Date;

/**
 * Created by Малик on 04.11.2014.
 */
public class InvoiceForPayment {
    private Long id;
    private Date date;
    private String number;
    private Supplier supplier;
    private Double priceSum = new Double(0);
    private Long version = new Long(0);


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
