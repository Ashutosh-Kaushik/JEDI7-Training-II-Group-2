package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminDaoImplementation implements AdminDaoInterface{

    private static volatile AdminDaoImplementation instance = null;
    private AdminDaoImplementation() {}
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
    public boolean approveStudents(int abc) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "select * from student where isApproved= 0";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int sId = rs.getInt(1);
                System.out.println(rs.getInt(1));
//                String s = "select * from user where userId = " +sId;
//                Statement st = con.createStatement();
//                ResultSet r = st.executeQuery(s);
//                System.out.println(r.getString(3)+ " " +r.getString(4));
            }
            Scanner in= new Scanner(System.in);
            System.out.println("Enter student id");
            int id = in.nextInt();
            sql = "UPDATE student SET isApproved = 1 where studentId = " + id;
            stmt.executeUpdate(sql);
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
