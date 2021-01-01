package com.wqie.students.model;

public class SelectNoIn {

    private Integer sno;

    private Integer cno;

    private String semester;

    public SelectNoIn(Integer sno, Integer cno, String semester) {
        this.sno = sno;
        this.cno = cno;
        this.semester = semester;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
