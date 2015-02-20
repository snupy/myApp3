package ru.malik.myApp3.server.services.utils;

import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import ru.malik.myApp3.server.business.types.BuildingProject;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectPagingLoadResultBean extends PagingLoadResultBean<BuildingProject> {
    protected BuildingProjectPagingLoadResultBean() {

    }
    public BuildingProjectPagingLoadResultBean(List<BuildingProject> list, int totalLength, int offset) {
        super(list, totalLength, offset);
    }
}
