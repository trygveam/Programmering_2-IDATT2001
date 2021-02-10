package edu.ntnu.idatt2001.trygveam.oblig2;

public abstract class Membership {

    private String membershipName;

    public Membership(String membershipName) {
        this.membershipName = membershipName;
    }

    public int registerPoints(int bonusPointBalance, int newPoints){
        return bonusPointBalance + newPoints;
    }

    public String getMembershipName(){
        return this.membershipName;
    }
}
