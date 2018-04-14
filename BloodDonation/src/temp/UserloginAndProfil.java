package temp;

import DL.UserLoginInfoDL;
import DL.UserLoginInfoDLImpl;
import Db.UserLoginInfoModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
@ManagedBean
@SessionScoped
public class UserloginAndProfil {
    private String userName;
    private String passwordhash;
    private String name;
    private String surname;
    private String email;
    private String durum;
    private String phoneNumber;
    private String mah,cd_sk,aprtno,city,county;
    private String bloodGroup;
    private String respons;
    private boolean state;
    private List<UserLoginInfoModel> userLoginInfoModelList=new ArrayList<UserLoginInfoModel>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
     public String getDurum(){
        return durum;
     }
    public String getRespons() {
        return respons;
    }

    public List<UserLoginInfoModel> getUserLoginInfoModelList() {
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        userLoginInfoModelList=employeeService.controlinfostate(userName,passwordhash);
        if(userLoginInfoModelList.size()==0){
            durum="Bilgireniz silinmiştir lütfen bilgileriniz güncelleyiniz";
            userLoginInfoModelList=employeeService.controlLogin("bos","bos");
            return userLoginInfoModelList;
        }
        else {
            userLoginInfoModelList=employeeService.controlLogin(userName,passwordhash);
            return userLoginInfoModelList;
        }

    }
    public String control(){
        mdbes md=new mdbes();
        try {
            passwordhash =md.mdbes_convert(passwordhash) ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        userLoginInfoModelList=employeeService.controlLogin(userName,passwordhash);
      if(userLoginInfoModelList.size()==1){
          userLoginInfoModelList=employeeService.controlinfostate(userName,passwordhash);
          if(userLoginInfoModelList.size()==1){
              return "userprofil";
          }
          else {
            userLoginInfoModelList=null;
              return "userprofil";
          }

      }
      else {
          respons="yanlış kullanıcı adı veya şifre girdiniz!!!";
          return null;
      }
    }
    public List<UserLoginInfoModel> getUserLoginInfoModel() {
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        userLoginInfoModelList=employeeService.controlinfoemail(email);
        if(userLoginInfoModelList.size()==1){
            userLoginInfoModelList = employeeService.findAllUserInfo();
            return userLoginInfoModelList;
        }
        else {
            respons="yanlış eposta girdiniz!!!";
            return null;
        }
    }
    public String changePassword(int id){
        UserLoginInfoDL employeeService = new UserLoginInfoDLImpl();
        if(userLoginInfoModelList.size()==1){
            employeeService.changePasswordUser(id,passwordhash);
            userLoginInfoModelList = employeeService.findAllUserInfo();
            respons="login";
            return respons;
        }
        else {
            return "email doğrulanamadı";
        }

    }
    public String updataUser(int id) {
        UserLoginInfoDLImpl employeeService = new UserLoginInfoDLImpl();
        employeeService.updateUserInfo( id,userName,name,surname,email, phoneNumber, mah,cd_sk,aprtno,city,county, bloodGroup);
        userLoginInfoModelList = employeeService.findAllUserInfo();
        return "userprofil";
    }
    public String pasifUserinfo(int id) {
        UserLoginInfoDLImpl employeeService = new UserLoginInfoDLImpl();
        employeeService.removeUserInfo(id);
        userLoginInfoModelList = employeeService.findAllUserInfo();
        return "userprofil";
    }

}

