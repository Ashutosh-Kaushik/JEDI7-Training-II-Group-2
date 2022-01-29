package com.flipkart.utils;

import com.flipkart.bean.Professor;

import java.sql.*;

public class ProfessorOperations implements ProfessorUtilsInterface {
    public Professor validateCredentialsWithDB(int userId,String password){
        try{
            //establishing connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crsregistration","root","root");
            String SQL = "select * from user,professor where user.userId="+userId+" and professor.professorId="+userId;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(SQL);
            if(rs.next()) {
                Professor professor=new Professor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
                con.close();
                return professor;
            }
            //while(rs.next())
            //    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    /*public static boolean validateCredentials2(int userId)throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crsregistration","root","root");
            String SQL = "select * from user,professor where user.userId="+userId+" and professor.professorId="+userId;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(SQL);
            if(rs.next()) {
                con.close();
                return true;
            }
            //while(rs.next())
            //    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8));
            //con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return false;
    }*/

    //public static void main(String[] args)throws ClassNotFoundException, SQLException {
        //validateCredentials2(102);
        /*Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crsregistration","root","root");
        String SQL = "INSERT INTO user(userId,userName,emailId,password,contactNo) "
                + "VALUES(?,?,?,?,?)";
        String SQL2="INSERT INTO professor(professorId,areaOfExpertise,yoe) "+ "VALUES(?,?,?)";
        Professor professor=new Professor(103,"Meghana","meghana@gmai.com","Meghana","9391645314",
                103,"Cloud",24);

        long id = 0;
        //inserting into table
        try (
             PreparedStatement pstmt = con.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, String.valueOf(professor.getUserId()));
            pstmt.setString(2, professor.getUserName());
            pstmt.setString(3,professor.getEmailId());
            pstmt.setString(4,professor.getPassword());
            pstmt.setString(5,professor.getContactNo());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //inserting into professor
        try (
                PreparedStatement pstmt = con.prepareStatement(SQL2,
                        Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, String.valueOf(professor.getUserId()));
            pstmt.setString(2, professor.getAreaOfExpertise());
            pstmt.setString(3,String.valueOf(professor.getYearsOfExperience()));



            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/



   // }
}
/*
import java.sql.*;
class MysqlCon{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/sonoo","root","root");
//here sonoo is database name, root is username and password
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next())
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
con.close();
}catch(Exception e){ System.out.println(e);}
}
}


String SQL = "INSERT INTO actor(first_name,last_name) "
                + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, actor.getFirstName());
            pstmt.setString(2, actor.getLastName());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

 */