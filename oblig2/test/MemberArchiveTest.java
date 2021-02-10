package edu.ntnu.idatt2001.trygveam.oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberArchiveTest {
    @Nested
    class testAddingMember{

        MemberArchive memberArchive = new MemberArchive();

        @Test
        public void returnTrueAfterAdding(){
            BonusMember member = new BonusMember(7, LocalDate.now(), 44000, "Tobias", "tobias@live.no", "1234");
            assertTrue(memberArchive.addMember(member));
        }

        @Test
        public void returneFalseAfterAdding(){
            BonusMember member = new BonusMember(6,LocalDate.now(), 74000, "Trygve", "trygveamundsen@live.no", "1234");
            assertFalse(memberArchive.addMember(member));
        }
    }

    @Nested
    class testRegisteringPoints{

        MemberArchive memberArchive = new MemberArchive();

        @Test
        public void returnTrueAfterRegisteringPoints(){
            assertTrue(memberArchive.registerPoints(1,500));
        }

        @Test
        public void returnFalseAfterRegisteringPointsWithMemberNotInHashmap(){
            assertFalse(memberArchive.registerPoints(10,500));
        }
    }
}
