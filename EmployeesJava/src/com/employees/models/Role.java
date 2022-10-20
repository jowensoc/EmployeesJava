package com.employees.models;

public class Role {

    Integer RoleID;
    String RoleName;

    private void initialise(Integer roleID, String roleName) {
        setRoleID(roleID);
        setRoleName(roleName);
    }

    public Role(Integer roleID, String roleName) {
        initialise(roleID, roleName);
    }

    public void setRoleID(Integer roleID) {
        RoleID = roleID;
    }

    public Integer getRoleID() {
        return RoleID;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleName() {
        return RoleName;
    }


}
