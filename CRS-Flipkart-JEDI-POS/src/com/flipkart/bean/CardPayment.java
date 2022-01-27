package com.flipkart.bean;

public class CardPayment {
    private String cardNumber;
    private String expirationDate;
    private String name;
    private int amount;

    public CardPayment(String cardNumber, String expirationDate, String name, int amount) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.name = name;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
