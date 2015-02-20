package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.BuildingProject;
import ru.malik.myApp3.server.repos.simple.BuildingProjectDao;
import ru.malik.myApp3.server.services.utils.BuildingProjectPagingLoadResultBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class BuildingProjectServiceTest {

    public static final String BUILDING_PROJECT_NAME_NEW = "2213/2323";
    public static final String BUILDING_PROJECT_NAME_UPDATE = "22ss3/s323";

    @Autowired
    BuildingProjectService service;

    @Test
    public void testSave() throws Exception {
        BuildingProject obj;
        obj = new BuildingProject();
        obj.setName(BUILDING_PROJECT_NAME_NEW);

        service.save(obj);
        assertNotNull(service.findById(obj.getId()));

        service.delete(obj);
    }

    @Test
    public void testUpdate() throws Exception {
        BuildingProject obj;
        obj = new BuildingProject();
        obj.setName(BUILDING_PROJECT_NAME_NEW);

        service.save(obj);

        obj.setName(BUILDING_PROJECT_NAME_UPDATE);
        service.update(obj);
        assertTrue(BUILDING_PROJECT_NAME_UPDATE.equals(service.findById(obj.getId()).getName()));

        service.delete(obj);
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        BuildingProject obj;
        obj = new BuildingProject();
        obj.setName(BUILDING_PROJECT_NAME_NEW);

        service.saveOrUpdate(obj);
        assertNotNull(service.findById(obj.getId()));

        obj.setName(BUILDING_PROJECT_NAME_UPDATE);
        service.saveOrUpdate(obj);
        assertTrue(BUILDING_PROJECT_NAME_UPDATE.equals(service.findById(obj.getId()).getName()));

        service.delete(obj);
    }

    @Test
    public void testGetAll() throws Exception {
        BuildingProject obj;

        int befCount = service.getAll().size();
        for (int i = 0; i < 100; i++) {
            obj = new BuildingProject();
            obj.setName(BUILDING_PROJECT_NAME_NEW);

            service.save(obj);
        }

        int aftCount = service.getAll().size();

        assertTrue(aftCount-befCount==100);

        for (BuildingProject buildingProject: service.getAll()){
            if (BUILDING_PROJECT_NAME_NEW.equals(buildingProject.getName())){
                service.delete(buildingProject);
            }
        }
    }

    @Test
    public void testFindById() throws Exception {
        BuildingProject obj;
        obj = new BuildingProject();
        obj.setName(BUILDING_PROJECT_NAME_NEW);

        service.save(obj);
        assertNotNull(service.findById(obj.getId()));

        service.delete(obj);
    }

    @Test
    public void testDelete() throws Exception {
        BuildingProject obj;
        obj = new BuildingProject();
        obj.setName(BUILDING_PROJECT_NAME_NEW);

        service.save(obj);
        service.delete(obj);
        assertNull(service.findById(obj.getId()));
    }

    @Test
    public void testDeleteAll() throws Exception {

        List<BuildingProject> list = new ArrayList<BuildingProject>();

        int befCount = service.getAll().size();
        for (int i = 0; i < 100; i++) {
            BuildingProject obj = new BuildingProject();
            obj.setName(BUILDING_PROJECT_NAME_NEW);

            list.add(obj);
        }

        for (BuildingProject buildingProject: list){
            if (BUILDING_PROJECT_NAME_NEW.equals(buildingProject.getName())){
                service.save(buildingProject);
            }
        }

        int aftCount = service.getAll().size();
        assertTrue(aftCount-befCount==100);

        service.deleteAll(list);
        aftCount = service.getAll().size();
        assertTrue(aftCount-befCount==0);

    }

    @Test
    public void testGetPagingList() throws Exception {
        BuildingProject obj;

        int befCount = service.getAll().size();
        for (int i = 0; i < 100; i++) {
            obj = new BuildingProject();
            obj.setName(BUILDING_PROJECT_NAME_NEW);

            service.save(obj);
        }

        BuildingProjectPagingLoadResultBean pl = service.getPagingList(befCount, 10, new ArrayList<SortInfoBean>(), new ArrayList<FilterConfigBean>());


        int aftCount = service.getAll().size();

        assertTrue(pl.getData().size()==10);
        assertTrue(pl.getTotalLength()==aftCount);

        for (BuildingProject buildingProject: service.getAll()){
            if (BUILDING_PROJECT_NAME_NEW.equals(buildingProject.getName())){
                service.delete(buildingProject);
            }
        }
    }
}