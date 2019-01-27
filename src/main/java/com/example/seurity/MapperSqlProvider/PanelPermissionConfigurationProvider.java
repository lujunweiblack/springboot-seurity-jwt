package com.example.seurity.MapperSqlProvider;

/**
 * @author: lujunwei
 * @time: 13:43 2019/1/27
 * @des:
 */
public class PanelPermissionConfigurationProvider {

    public String querySysPermissionByRoles(String roles) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT\n" +
                "\tsp.parent_id,\n" +
                "\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tNAME\n" +
                "\t\tFROM\n" +
                "\t\t\tsys_permission\n" +
                "\t\tWHERE\n" +
                "\t\t\tid = sp.parent_id\n" +
                "\t) name\n" +
                "FROM\n" +
                "\tsys_role sr,\n" +
                "\tsys_role_permission srp,\n" +
                "\tsys_permission sp\n" +
                "WHERE\n" +
                "\tsrp.sys_role_id = sr.id\n" +
                "AND sp.id = srp.sys_permission_id\n" +
                "AND sr.available = 1\n" +
                "AND sp.available = 1\n" +
                "AND sr. CODE IN ("+roles+")");
        return sql.toString();
    }
}
