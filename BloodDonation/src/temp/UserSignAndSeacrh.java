package temp;


import DL.UserLoginInfoDL;
import DL.UserLoginInfoDLImpl;
import DL.UserLoginService;
import Db.UserLoginInfoModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserSignAndSeacrh {
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String mah,cd_sk,aprtno,city,county;
    private String bloodGroup;
    private boolean state;
    private List<UserLoginInfoModel> userLoginInfoModelList=new ArrayList<UserLoginInfoModel>();

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
        if(name!=null)
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


    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMah() {
        return mah;
    }

    public void setMah(String mah) {
        this.mah = mah;
    }

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


    public List<UserLoginInfoModel> getUserLoginInfoModelList() {
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        userLoginInfoModelList=employeeService.findUserInfo(mah,city,county,bloodGroup);
        return userLoginInfoModelList;
    }
    public String addUser(){
        mdbes md=new mdbes();
            state=true;
        try {
            password= md.mdbes_convert(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        EntityManager entityManager=JpaFactory.getInstance().getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new UserLoginInfoModel(
                    userName, password,  name, surname, email, phoneNumber, mah,cd_sk,aprtno,city,county, bloodGroup, state
            ));
            entityManager.getTransaction().commit();
            entityManager.close();
            return "index";
    }
    public void updataUser(int id) {
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        employeeService.removeUserInfo(id);
        userLoginInfoModelList = employeeService.findAllUserInfo();
    }

}
