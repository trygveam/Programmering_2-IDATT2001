package edu.ntnu.idatt2001.trygveam.oblig2;

public class GoldMembership extends Membership {

    private final float POINTS_SCALING_FACTOR_LEVEL1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL2 = 1.5f;

    public GoldMembership() {
        super("gold");
    }

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int points = 0;
        if(bonusPointBalance >= 90000){
            points = (int) Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL2);
        }
        else {
            points = (int) Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL1);
        }
       return super.registerPoints(bonusPointBalance, newPoints);
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
