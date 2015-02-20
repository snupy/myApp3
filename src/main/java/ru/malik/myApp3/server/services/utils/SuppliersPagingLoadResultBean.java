package ru.malik.myApp3.server.services.utils;

import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import ru.malik.myApp3.server.business.types.Supplier;

import java.util.List;

/**
 * Created by Малик on 10.11.2014.
 */
public class SuppliersPagingLoadResultBean extends PagingLoadResultBean<Supplier> {
    protected SuppliersPagingLoadResultBean() {

    }
    public SuppliersPagingLoadResultBean(List<Supplier> list, int totalLength, int offset) {
        super(list, totalLength, offset);
    }
}
