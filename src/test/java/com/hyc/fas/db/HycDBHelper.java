package com.hyc.fas.db;

import com.hyc.fas.db.entity.BusSubs;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        /*List<UserInfo> list = UserInfo.genBatchUserInfos(500000);
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
            *//*pst.execute();
            connection.commit();*//*

            if (i % 50 == 0 || i == list.size() - 1) {
                pst.executeBatch();
                connection.commit();
            }
        }*/




        Connection connection = DBUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement pst = null;
        ResultSet rs = null;


        /*pst = connection.prepareStatement("INSERT INTO bus_tend_info(b_t_i_id,prod_limit,trem_util" +
                "" +
                ",deal_num,succ_num,total_num,loan_no,loan_name,b_p_code,b_p_name,rate,rate_type,c_id," +
                "loan_amount,min_loan_amount,status) VALUES " +
                "(?,?,?,0,0,10,'000000','00000','P100','北京放',0.1,'1','00000',100," +
                "100,'01')");
        for (int i = 0 ; i< 100;i++) {
            BusTendInfo busTendInfo = BusTendInfo.build();
            pst.setString(1,busTendInfo.getB_t_i_id());
            pst.setString(2, busTendInfo.getProd_limit());
            pst.setString(3,busTendInfo.getTrem_util());
            pst.execute();
            connection.commit();
        }
        connection.commit();*/


        pst = connection.prepareStatement("SELECT b_t_i_id FROM bus_tend_info");
        rs = pst.executeQuery();
        List<String> btids = new ArrayList<>();
        while (rs.next()) {
            btids.add(rs.getString(1));
        }
        List<String> uiids = new ArrayList<>();
        pst = connection.prepareStatement("SELECT u_i_id FROM user_info");
        rs = pst.executeQuery();
        while (rs.next()) {
            uiids.add(rs.getString(1));
        }


        pst = connection.prepareStatement("INSERT INTO bus_subs (o_s_id,b_t_i_id,inve_c_id,c_i_id" +
                ",amount,sub_copies,tx_date,curr_num,status) " +
                "VALUES " +
                "(?,?,?,'000',?,'000',?,0,?)");


        int cnt = 0;

        BusSubs busSubs = null;
        for (int i = 0 ; i < btids.size() ; i++) {
            for (int j = 0 ; j < uiids.size() ;j++) {
                cnt++;
                busSubs = BusSubs.build(btids.get(i),uiids.get(j));
                pst.setString(1,busSubs.getO_s_id());
                pst.setString(2,busSubs.getB_t_i_id());
                pst.setString(3,busSubs.getInve_c_id());
                pst.setBigDecimal(4,busSubs.getAmount());
                pst.setString(5,busSubs.getTx_date());
                pst.setString(6,busSubs.getStatus());

                pst.addBatch();

                if (cnt  == 50 || (cnt < 50 && i == btids.size()-1 && j == uiids.size()-1)) {
                    pst.executeBatch();
                    connection.commit();
                    cnt = 0;
                }
                busSubs = null;
            }
        }

        connection.commit();

        DBUtil.close(rs);
        DBUtil.close(pst);
        DBUtil.close(connection);


    }
}
