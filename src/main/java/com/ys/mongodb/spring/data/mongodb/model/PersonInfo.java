package com.ys.mongodb.spring.data.mongodb.model;

/**
 * @author HuaDong
 * @date 2019/4/3 13:54
 */
public class PersonInfo {

    private int id;

    private String person_name;

    private String sex;

    private String relationship;

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", person_name='" + person_name + '\'' +
                ", sex='" + sex + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }

    public PersonInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
