package ru.malik.myApp3.server.repos.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.BuildingProject;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
@Transactional
public class BuildingProjectDaoTest {
    final public static String BUILDING_PROJECT_NAME_NEW = "sssddds1234567";
    final public static String BUILDING_PROJECT_NAME_UPDATE = "sss1qqsdsds342567";

    private BuildingProject createNewBuildingProject(String name) {
        BuildingProject buildingProjectNew = new BuildingProject();
        buildingProjectNew.setName(name);

        buildingProjectDao.create(buildingProjectNew);
        return buildingProjectNew;
    }

    @Autowired
    BuildingProjectDao buildingProjectDao;


    @Test
    public void testInjectBuildingProjectDao() {
        assertNotNull("Ошибка инъекции BuildingProject=" + buildingProjectDao, buildingProjectDao);
    }

    @Test
    public void testCreateBuildingProject() {
        BuildingProject buildingProjectNew = createNewBuildingProject(BUILDING_PROJECT_NAME_NEW);

        BuildingProject buildingProjectOld = buildingProjectDao.read(buildingProjectNew.getId());
        assertNotNull("Ошибка записи в БД BuildingProject=" + buildingProjectOld, buildingProjectOld);
    }

    @Test
    public void testDeleteBuildingProject() {
        BuildingProject buildingProjectNew = createNewBuildingProject(BUILDING_PROJECT_NAME_NEW);

        for (BuildingProject buildingProject : buildingProjectDao.findByName(BUILDING_PROJECT_NAME_NEW)) {
            buildingProjectDao.delete(buildingProject);
        }

        int count = buildingProjectDao.findByName(BUILDING_PROJECT_NAME_NEW).size();

        assertTrue("Ошибка удаления записей из БД количество не удаленных=" + count, count == 0);
    }

    @Test
    public void testUpdateBuildingProject() {

        int begCount = buildingProjectDao.findByName(BUILDING_PROJECT_NAME_UPDATE).size();

        BuildingProject buildingProjectNew = createNewBuildingProject(BUILDING_PROJECT_NAME_NEW);

        BuildingProject buildingProjectOld = buildingProjectDao.read(buildingProjectNew.getId());
        buildingProjectOld.setName(BUILDING_PROJECT_NAME_UPDATE);

        buildingProjectDao.update(buildingProjectOld);
        buildingProjectOld = null;

        buildingProjectOld = buildingProjectDao.findByName(BUILDING_PROJECT_NAME_UPDATE).get(0);
        assertNotNull("Ошибка изменения записи в БД BuildingProject=" + buildingProjectOld, buildingProjectOld);

        int endCount = buildingProjectDao.findByName(BUILDING_PROJECT_NAME_UPDATE).size();
        assertTrue("Ошибка изменения записи в БД BuildingProject=" + buildingProjectOld, endCount - begCount == 1);
    }

    @Test
    public void testReadBuildingProject() {
        BuildingProject buildingProjectNew = createNewBuildingProject(BUILDING_PROJECT_NAME_NEW);
        BuildingProject buildingProjectOld = buildingProjectDao.read(buildingProjectNew.getId());
        assertNotNull("Ошибка чтения записи из БД по id BuildingProject=" + buildingProjectOld, buildingProjectOld);
    }
}