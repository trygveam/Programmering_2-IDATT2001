package edu.ntnu.idatt2001.trygveam.oblig2;

public class BasicMembership extends Membership {

    public BasicMembership() {
       super("basic");
    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
