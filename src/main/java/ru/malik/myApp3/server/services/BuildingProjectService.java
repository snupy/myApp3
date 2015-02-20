package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import ru.malik.myApp3.server.business.types.BuildingProject;
import ru.malik.myApp3.server.services.utils.BuildingProjectPagingLoadResultBean;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
public interface BuildingProjectService {
    public void save(BuildingProject obj);
    public void update(BuildingProject obj);
    public void saveOrUpdate(BuildingProject obj);
    public List<BuildingProject> getAll();
    public BuildingProject findById(Long id);
    public void delete(BuildingProject obj);
    public void deleteAll(List<BuildingProject> list);
    public BuildingProjectPagingLoadResultBean getPagingList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig);
}
