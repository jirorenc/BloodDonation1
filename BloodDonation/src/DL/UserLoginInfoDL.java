package DL;

import Db.UserLoginInfoModel;

import java.util.List;

public interface UserLoginInfoDL {
    public UserLoginInfoModel insertUserInfo(UserLoginInfoModel employee);

    public UserLoginInfoModel findUserInfo(int id);
    public List<UserLoginInfoModel> findUserInfo(String mah,String city,String county,String blood);
    public List<UserLoginInfoModel> controlLogin(String username,String password);
    public List<UserLoginInfoModel> controlinfostate(String username,String password);
    public List<UserLoginInfoModel> controlinfoemail(String email);
    public List<UserLoginInfoModel> findAllUserInfo();


    public void removeUserInfo(int id);
    public void changePasswordUser(int id,String password);
}
