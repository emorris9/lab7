package edu.luc.cs.cs271.lab2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestTeam {
  
  Team makeTeamFixture(final String name, final String headcoach, final int funding) {
    return new Team(name, headcoach, funding);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidName() {
    new Team(null, "Klinsmann", 500);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidHeadCoach() {
    new Team("Team 5", null, 500);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidFunding() {
    new Team("Team 5", "Klinsmann", 0);
  }

  @Test
  public void testGetName() {
    final String name = "USA";
    final Team t = makeTeamFixture(name, "Klinsmann", 500);
    assertEquals(name, t.getName());
  }

  @Test
  public void testGetHeadCoach() {
    final String headcoach = "Klinsmann";
    final Team t = makeTeamFixture("USA", headcoach, 500);
    assertEquals(headcoach, t.getHeadcoach());
  }

  @Test
  public void testGetFunding() {
    final int funding = 500;
    final Team t = makeTeamFixture("USA", "Klinsmann", funding);
    assertEquals(funding, t.getFunding());
  }
}