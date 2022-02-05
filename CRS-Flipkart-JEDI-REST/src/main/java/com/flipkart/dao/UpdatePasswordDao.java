package com.flipkart.dao;

import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;
//import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePasswordDao implements UpdatePasswordInterface{

  //  final Logger logger = Logger.getLogger(UpdatePasswordDao.class);
    @Override
    public String updatePassword(String userId, String oldpassword,String newpassword) throws SQLException {
        Connection connection = DBUtils.getConnection();
        if(connection==null)
            System.out.println("connection not established");
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(SQLQueriesConstants.GET_DETAILS);
            preparedStatement1.setString(1, userId);
            preparedStatement1.setString(2, oldpassword);
            ResultSet rowsAffected1 = preparedStatement1.executeQuery();
            if (rowsAffected1.next()) {
                PreparedStatement preparedStatement = connection.prepareStatement((SQLQueriesConstants.UPDATE_PASSWORD));
                preparedStatement.setString(2, userId);
                preparedStatement.setString(1, newpassword);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 1) {
                   // logger.info("Password Updated Successfully!!");
                } else {
                    //logger.info("Password not updated");
                }
            }
            else
            {
              //  logger.info("User Credentials Not Correct");
            }
        }
        catch (SQLException e)
        {
            //logger.info("User Credentials Norrrrt Correct");
            e.printStackTrace();
        }
        return null;
    }
}
