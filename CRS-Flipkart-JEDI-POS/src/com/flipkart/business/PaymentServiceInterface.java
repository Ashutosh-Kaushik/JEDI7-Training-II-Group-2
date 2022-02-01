package com.flipkart.business;

import com.flipkart.bean.Student;

import java.sql.SQLException;

public interface PaymentServiceInterface {
    void payFees(Student student) throws SQLException;
}
