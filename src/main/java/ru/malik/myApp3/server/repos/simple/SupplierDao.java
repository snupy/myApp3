package ru.malik.myApp3.server.repos.simple;

import org.springframework.stereotype.Repository;
import ru.malik.myApp3.server.business.types.Supplier;

import java.util.List;

/**
 * Created by Малик on 04.11.2014.
 */


public interface SupplierDao extends GenericDao<Supplier, Long> {
    List<Supplier> findByName(String name);
}
