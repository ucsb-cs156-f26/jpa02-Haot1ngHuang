package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Haoting H.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubID() {
        assertEquals("Haot1ngHuang", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team_name(){
        Team t = Developer.getTeam();
        assertEquals("f26-04", t.getName());
    }

    @Test
    public void getTeam_returns_correct_members(){
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Athena Chen"), "Team should contain Athena Chen");
        assertTrue(t.getMembers().contains("Austin Li"), "Team should contain Austin Li");
        assertTrue(t.getMembers().contains("Haoting Huang"), "Team should contain Haoting Huang");
        assertTrue(t.getMembers().contains("Harry Lai"), "Team should contain Harry Lai");
        assertTrue(t.getMembers().contains("Jonathan Lo"), "Team should contain Jonathan Lo");
        assertTrue(t.getMembers().contains("Sarah Hong"), "Team should contain Sarah Hong");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
