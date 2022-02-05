package com.flipkart.dao;

import java.sql.SQLException;

public interface PaymentDaoInterface {
    void insertIntoPayment(String paymentId, String paymentType) throws SQLException;
    void insertIntoBookkeeper(String paymentId, String paymentType, int semester) throws SQLException;
    void updateFeeStatus(String studentId) throws SQLException;
}
