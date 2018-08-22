package com.entity;

import java.io.Serializable;

/**
 * 部门表实体类
 *
 * @author lenovo
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -2914108107744037164L;
    private Byte deptno; // OID(主键id)
    private String dname;//部门名称
    private String loc;//区域


    public Byte getDeptno() {
        return deptno;
    }

    public void setDeptno(Byte deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
