package DL;

import Db.UserLoginInfoModel;

import java.util.List;

public class UserLoginService implements UserLoginInfoDL {
      private UserLoginInfoDLImpl loginInfoDL;
      public  UserLoginService (){
          loginInfoDL=new UserLoginInfoDLImpl();
      }
      private UserLoginInfoDLImpl getLoginInfoDL(){
          return loginInfoDL;
      }

    public UserLoginInfoModel insertUserInfo(UserLoginInfoModel employee) {
        return null;
    }

    public UserLoginInfoModel findUserInfo(int id) {
        return null;
    }

    public List<UserLoginInfoModel>  findUserInfo(String mah,String city,String county,String blood) {
        return null;
    }

    public List<UserLoginInfoModel> controlLogin(String username, String password) {
        return null;
    }

    public List<UserLoginInfoModel> controlinfostate(String username, String password) {
        return null;
    }

    public List<UserLoginInfoModel> controlinfoemail(String email) {
        return null;
    }


    public List<UserLoginInfoModel> findAllUserInfo() {
        return null;
    }

    public List<UserLoginInfoModel> findBloodInfo() {
        return null;
    }

    public void removeUserInfo(int id) {

    }

    public void changePasswordUser(int id,String password) {

    }
}
