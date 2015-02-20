package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.BuildingProject;
import ru.malik.myApp3.server.repos.simple.BuildingProjectDao;
import ru.malik.myApp3.server.services.utils.BuildingProjectPagingLoadResultBean;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
@Service
@Transactional
public class BuildingProjectServiceImpl implements BuildingProjectService {
    @Autowired
    BuildingProjectDao dao;

    @Override
    public void save(BuildingProject obj) {
        dao.create(obj);
    }

    @Override
    public void update(BuildingProject obj) {
        dao.update(obj);
    }

    @Override
    public void saveOrUpdate(BuildingProject obj) {
        dao.saveOrUpdate(obj);
    }

    @Override
    public List<BuildingProject> getAll() {
        return dao.getAll();
    }

    @Override
    public BuildingProject findById(Long id) {
        return dao.read(id);
    }

    @Override
    public void delete(BuildingProject obj) {
        dao.delete(obj);
    }

    @Override
    public void deleteAll(List<BuildingProject> list) {
        for (BuildingProject obj : list) {
            delete(obj);
        }
    }

    @Override
    public BuildingProjectPagingLoadResultBean getPagingList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig) {
        List<BuildingProject> list = dao.getAll(offset, limit, sortInfo, filterConfig);
        int count = dao.count().intValue();

        BuildingProjectPagingLoadResultBean resultBean = new BuildingProjectPagingLoadResultBean(list, count, offset);
        return resultBean;
    }
}
