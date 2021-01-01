package com.wqie.students.model;

public class SelectCourse {
    private Integer id;

    private Integer sno;

    private Integer cno;

    private Integer tno;

    private String semester;

    private Integer credit;

    public SelectCourse(Integer id, Integer sno, Integer cno, Integer tno, String semester, Integer credit) {
        this.id = id;
        this.sno = sno;
        this.cno = cno;
        this.tno = tno;
        this.semester = semester;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}