package edu.ntnu.idatt2001.trygveam.oblig2;

import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;
        checkAndSetMembership();
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void checkAndSetMembership(){
        if(this.bonusPointsBalance >= SILVER_LIMIT && this.bonusPointsBalance < GOLD_LIMIT){
            this.membership = new SilverMembership();
        }
        else if(this.bonusPointsBalance >= GOLD_LIMIT){
            this.membership =  new GoldMembership();
        }
        else{
            this.membership = new BasicMembership();
        }
    }

    public void registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }

    public static int getSilverLimit() {
        return SILVER_LIMIT;
    }

    public static int getGoldLimit() {
        return GOLD_LIMIT;
    }

    @Override
    public String toString() {
        return "BonusMember{" +
                "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name + '\'' +
                ", eMailAddress='" + eMailAddress + '\'' +
                ", password='" + password + '\'' +
                ", membership=" + membership +
                '}';
    }
}
