package Db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLoginInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String mah,cd_sk,aprtno,city,county;
    private String bloodGroup;
    private boolean state;

    public String getCd_sk() {
        return cd_sk;
    }

    public void setCd_sk(String cd_sk) {
        this.cd_sk = cd_sk;
    }

    public String getAprtno() {
        return aprtno;
    }

    public void setAprtno(String aprtno) {
        this.aprtno = aprtno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public UserLoginInfoModel(String userName, String password, String name, String surname, String email, String phoneNumber, String mah,String cd_sk,String aprtno,String city,String county, String bloodGroup, boolean state) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mah = mah;
        this.cd_sk = cd_sk;
        this.aprtno = aprtno;
        this.city = city;
        this.county = county;
        this.bloodGroup = bloodGroup;
        this.state = state;
    }

    public UserLoginInfoModel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMah() {
        return mah;
    }

    public void setMah(String address) {
        this.mah = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}
