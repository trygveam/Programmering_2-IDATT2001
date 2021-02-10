package edu.ntnu.idatt2001.trygveam.oblig2;

public class SilverMembership extends Membership {

    private final float POINTS_SCALING_FACTOR = 1.2f;

    public SilverMembership() {
        super("silver");

    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return super.registerPoints(bonusPointBalance, (int) Math.round(newPoints * POINTS_SCALING_FACTOR));
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
