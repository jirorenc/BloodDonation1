package DL;

import Db.UserLoginInfoModel;
import temp.JpaFactory;
import temp.mdbes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserLoginInfoDLImpl implements UserLoginInfoDL {
    private EntityManager entityManager;
    public UserLoginInfoDLImpl() {
        entityManager = JpaFactory.getInstance().getEntityManager();
    }
    public UserLoginInfoModel insertUserInfo(UserLoginInfoModel userLoginInfoModel) {
        entityManager.getTransaction().begin();
        entityManager.persist(userLoginInfoModel);
        entityManager.getTransaction().commit();
        return userLoginInfoModel;
    }
    public UserLoginInfoModel findUserInfo(int id) {
        return entityManager.find(UserLoginInfoModel.class,id);
    }

    public List<UserLoginInfoModel> findUserInfo(String mah,String city,String county,String blood) {
        if(mah!=null&&city!=null&&county!=null&&blood!=null){
            TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e" +
                            " where (e.bloodGroup='"+blood+"' and e.county='"+county+"' and ( e.mah='"+mah+"' or e.city='"+city+"'))and e.state=true"
                    , UserLoginInfoModel.class);
            return query.getResultList();
        }
        else{
            TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e where e.bloodGroup='"+blood+"' ", UserLoginInfoModel.class);
            return query.getResultList();
        }
    }
    public List<UserLoginInfoModel> controlLogin(String username, String password) {
        TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e where e.userName='"+username+"' and e.password='"+password+"' ", UserLoginInfoModel.class);
        return query.getResultList();
    }
    public List<UserLoginInfoModel> controlinfostate(String username, String password) {
        TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e where e.userName='"+username+"' and e.password='"+password+"' and e.state=true ", UserLoginInfoModel.class);
        return query.getResultList();
    }

    public List<UserLoginInfoModel> controlinfoemail(String email) {
        TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e where e.email='"+email+"'  ", UserLoginInfoModel.class);
        return query.getResultList();
    }

    public List<UserLoginInfoModel> findAllUserInfo() {
        TypedQuery<UserLoginInfoModel> query = entityManager.createQuery("Select e from UserLoginInfoModel e ", UserLoginInfoModel.class);
        return query.getResultList();
    }
    public void removeUserInfo(int id) {
        UserLoginInfoModel userLoginInfoModel = findUserInfo(id);
        userLoginInfoModel.setState(false);
        if (userLoginInfoModel != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(userLoginInfoModel);
            entityManager.getTransaction().commit();
        }
    }
    public void changePasswordUser(int id,String password){
        UserLoginInfoModel userLoginInfoModel = findUserInfo(id);
        mdbes md=new mdbes();
        try {
            password=md.mdbes_convert(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userLoginInfoModel.setPassword(password);
        if (userLoginInfoModel != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(userLoginInfoModel);
            entityManager.getTransaction().commit();
        }

    }
    public void updateUserInfo(int id,String userName, String name, String surname, String email, String phoneNumber,
                               String mah,String cd_sk,String aprtno,String city,String county, String bloodGroup) {
        UserLoginInfoModel userLoginInfoModel = findUserInfo(id);
        if(userName!=null)
        userLoginInfoModel.setUserName(userName);
        if(name!=null)
        userLoginInfoModel.setName(name);
        if(surname!=null)
        userLoginInfoModel.setSurname(surname);
        if(email!=null)
        userLoginInfoModel.setEmail(email);
        if(phoneNumber!=null)
        userLoginInfoModel.setPhoneNumber(phoneNumber);
        if(mah!=null)
        userLoginInfoModel.setMah(mah);
        if(cd_sk!=null)
        userLoginInfoModel.setCd_sk(cd_sk);
        if(aprtno!=null)
        userLoginInfoModel.setAprtno(aprtno);
        if(city!=null)
        userLoginInfoModel.setCity(city);
        if(county!=null)
        userLoginInfoModel.setCounty(county);
        if(bloodGroup!=null)
        userLoginInfoModel.setBloodGroup(bloodGroup);
        if (userLoginInfoModel != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(userLoginInfoModel);
            entityManager.getTransaction().commit();
        }
    }
}
