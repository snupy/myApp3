package ru.malik.myApp3.server.business.types;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.malik.myApp3.server.services.BuildingProjectService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectLocator extends Locator<BuildingProject, Long> {
    private BuildingProjectService service;

    @Override
    public BuildingProject create(Class<? extends BuildingProject> aClass) {
        return new BuildingProject();
    }

    @Override
    public BuildingProject find(Class<? extends BuildingProject> aClass, Long aLong) {
        return getService().findById(aLong);
    }

    @Override
    public Class<BuildingProject> getDomainType() {
        return BuildingProject.class;
    }

    @Override
    public Long getId(BuildingProject buildingProject) {
        return buildingProject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(BuildingProject buildingProject) {
        return buildingProject.getVersion();
    }

    private BuildingProjectService getService() {
        if(service==null) {
            HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
            service = context.getBean(BuildingProjectService.class);
        }
        return service;
    }

}
