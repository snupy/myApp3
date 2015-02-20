package ru.malik.myApp3.server.business.types;

/**
 * Created by Малик on 04.11.2014.
 */
public class BuildingProject {
    private String name;
    private Long id;
    private Long version = new Long(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
