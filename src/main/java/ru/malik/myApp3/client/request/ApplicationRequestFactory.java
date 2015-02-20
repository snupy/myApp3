package ru.malik.myApp3.client.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * Created by Малик on 09.11.2014.
 */
public interface ApplicationRequestFactory extends RequestFactory {
    SupplierRequest supplierRequest();
    InvoiceForPaymentRequest invoiceForPaymentRequest();
    BuildingProjectRequest buildingProjectRequest();
}
