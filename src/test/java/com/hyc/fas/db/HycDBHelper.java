package com.hyc.fas.db;

import com.hyc.fas.db.entity.UserInfo;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 初始化数据库记录，用户测试性能
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 19:04
 */
public class HycDBHelper {


    private final static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static  char[] firstName = "欧式的阳台四面透光全落地式的玻璃设计让".toCharArray();
    public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
//        for (int i = 0; i < 10; i++) {
            // System.out.println(String.format("%s%08d", TimeUtil.getTime16(),atomicInteger.getAndIncrement()));
            //System.out.println((char)firstName[i]);
            //System.out.println((char)firstName[i]);
//        }




        List<UserInfo> list = UserInfo.genBatchUserInfos(500000);

        Connection connection = DBUtil.getConnection();
        connection.setAutoCommit(false);

        // String u_i_id, String u_i_type, String real_name, String create_date_time, String phone_v, String ty_id,
        // String ty_cpsid, String pass_word, String phone, String status

        PreparedStatement pst = connection.prepareStatement("INSERT INTO user_info(u_i_id,u_i_type,real_name,create_date_time," +
                "" +
                "phone_v,ty_id,ty_cpsid,pass_word,phone,status,u_i_name,channel) VALUES (?,?,?,?,?,?,?,?,?,?,'u_i_name','1')");
        for (int i = 0 ; i < list.size() ; i++) {
            pst.setString(1, list.get(i).getU_i_id());
            pst.setString(2, list.get(i).getU_i_type());
            pst.setString(3, list.get(i).getReal_name());
            pst.setString(4, list.get(i).getCreate_date_time());
            pst.setString(5, list.get(i).getPhone_v());
            pst.setString(6, list.get(i).getTy_id());
            pst.setString(7, list.get(i).getTy_cpsid());
            pst.setString(8, list.get(i).getPass_word());
            pst.setString(9, list.get(i).getPhone());
            pst.setString(10, list.get(i).getStatus());
            pst.addBatch();
            /*pst.execute();
            connection.commit();*/

            if (i % 50 == 0 || i == list.size() - 1) {
                pst.executeBatch();
                connection.commit();
            }


        }

        DBUtil.close(pst);
        DBUtil.close(connection);


    }
}
