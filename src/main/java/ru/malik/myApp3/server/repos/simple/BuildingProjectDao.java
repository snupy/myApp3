package ru.malik.myApp3.server.repos.simple;

import ru.malik.myApp3.server.business.types.BuildingProject;

import java.util.List;

/**
 * Created by Малик on 04.11.2014.
 */
public interface BuildingProjectDao extends GenericDao<BuildingProject, Long>  {
    List<BuildingProject> findByName(String name);
}
