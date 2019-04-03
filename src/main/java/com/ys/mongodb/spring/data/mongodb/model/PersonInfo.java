package com.ys.mongodb.spring.data.mongodb.model;

/**
 * @author HuaDong
 * @date 2019/4/3 13:54
 */
public class PersonInfo {

    public final static String COLLECTION_NAME = PersonInfo.class.getSimpleName();

    private int id;

    private String person_name;

    private String sex;

    private String relationship;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonInfo(int id, String person_name, String sex, String relationship) {
        this.id = id;
        this.person_name = person_name;
        this.sex = sex;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", person_name='" + person_name + '\'' +
                ", sex='" + sex + '\'' +
                ", relationship='" + relationship + '\'' +
                ", address=" + address +
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
