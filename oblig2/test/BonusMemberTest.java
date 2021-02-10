package edu.ntnu.idatt2001.trygveam.oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusMemberTest {

    @Nested
    class correctMembershipWhenCreatingMember{

        BonusMember bm = new BonusMember(1, LocalDate.now(),10000, "Per", "per@live.no","1234");

        @Test
        public void correctMembership(){
            assertEquals("basic",bm.getMembership().getMembershipName());
        }

        @Test
        public void correctMembershipAfterAddingPoints(){
            bm.registerBonusPoints(15000);
            assertEquals("silver",bm.getMembership().getMembershipName());
        }
    }



}
