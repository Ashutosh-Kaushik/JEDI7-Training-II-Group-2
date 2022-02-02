package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtils;

import java.sql.*;
import java.util.Scanner;

public class AdminDaoImplementation implements AdminDaoInterface{

    private static volatile AdminDaoImplementation instance = null;
    public AdminDaoImplementation() {}
    public static AdminDaoImplementation getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImplementation.class) {
                instance = new AdminDaoImplementation();
            }
        }
        return instance;
    }

    @Override
    public boolean addProfessor(Professor professor) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "insert into user values(" + professor.getUserId() + ", '" + professor.getPassword()+ "' , '"+ professor.getUserName()+ "', '" + professor.getEmailId() + "' , '" + professor.getContactNo() + "')";
            stmt.executeUpdate(sql);

            sql = "insert into professor values("+ professor.getUserId()+ " ,' "+professor.getAreaOfExpertise()+"',' "+professor.getYearsOfExperience()+"')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            ok = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }

    public boolean validateCredentials(String adminId, String password){
        try{
            Connection conn = DBUtils.getConnection();

            String sql = "SELECT * FROM user where userId like '"+adminId+"' and password like  '"+password+"'";
//            String sql = "select * from user where userid="+studentId+" and password="+password;
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }
    @Override
    public boolean addCourse(Course course) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "insert into course values(" + course.getCourseId() + ", '" + course.getCourseName()+ "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            ok = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public boolean dropCourse(int courseId) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "DELETE FROM course WHERE courseId= " + courseId;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            ok = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public boolean approveStudents() {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            Scanner in= new Scanner(System.in);
            int ch =1;
            while(ch!=0) {
                String sql = "select * from student where isApproved= 0";
                ResultSet rs = stmt.executeQuery(sql);
                int flag=0;
                System.out.println("Here is a list of all pending students ++++++++++++");
                while (rs.next()) {
                    int sId = rs.getInt(1);
                    System.out.println(rs.getInt(1));
                    flag=1;
//                String s = "select * from user where userId = " +sId;
//                Statement st = con.createStatement();
//                ResultSet r = st.executeQuery(s);
//                System.out.println(r.getString(3)+ " " +r.getString(4));
                }
                if(flag==1) {
                    System.out.println("Enter student id");
                    int id = in.nextInt();
                    sql = "UPDATE student SET isApproved = 1 where studentId = " + id;
                    stmt.executeUpdate(sql);
                }
                else{
                    System.out.println("No student left to be approved");
                }
                System.out.println("To exit, press 0 : To continue, press 1");
                ch = in.nextInt();
            }
        } catch (SQLException e) {
            ok = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }

//
//    @Override
//    public ArrayList<Grade> fetchGrade(int userId) {
//        return null;
//    }
}
