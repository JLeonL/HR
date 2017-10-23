/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

/**
 *
 * @author usuario
 */
public class Department {
    
    private int departmentId;
    private String departmentName;
    private Employee manager;
    private Location location;

    public Department() {
    }

    public Department(int deparmentId, String departmentName, Employee manager, Location location) {
        this.departmentId = deparmentId;
        this.departmentName = departmentName;
        this.manager = manager;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int deparmentId) {
        this.departmentId = deparmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
    
}
