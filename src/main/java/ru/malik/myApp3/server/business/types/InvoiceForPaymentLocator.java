package ru.malik.myApp3.server.business.types;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.malik.myApp3.server.services.InvoiceForPaymentService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Малик on 14.12.2014.
 */
public class InvoiceForPaymentLocator extends Locator<InvoiceForPayment, Long> {
    private InvoiceForPaymentService invoiceForPaymentService;
    @Override
    public InvoiceForPayment create(Class<? extends InvoiceForPayment> clazz) {
        return new InvoiceForPayment();
    }

    @Override
    public InvoiceForPayment find(Class<? extends InvoiceForPayment> clazz, Long id) {
        return getInvoiceForPaymentService().findById(id);
    }

    @Override
    public Class<InvoiceForPayment> getDomainType() {
        return InvoiceForPayment.class;
    }

    @Override
    public Long getId(InvoiceForPayment domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(InvoiceForPayment domainObject) {
        return domainObject.getVersion();
    }


    private InvoiceForPaymentService getInvoiceForPaymentService() {
        if(invoiceForPaymentService==null) {
            HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
            invoiceForPaymentService = context.getBean(InvoiceForPaymentService.class);
        }
        return invoiceForPaymentService;
    }
}
