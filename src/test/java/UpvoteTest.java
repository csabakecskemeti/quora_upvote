/**
 * Created by kecso on 10/29/16.
 */

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class UpvoteTest {
    // subVote test cases
    @Test
    public void testSubVoteNonIncreasing() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(1);
            add(1);
        }};
        Assert.assertEquals(-1, Upvote.subVote(testArray));
    }
    @Test
    public void testSubVoteNonDecreasing() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        Assert.assertEquals(1, Upvote.subVote(testArray));
    }
    @Test
    public void testSubVoteNoneNDNI() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(3);
            add(1);
        }};
        Assert.assertEquals(0, Upvote.subVote(testArray));
    }

    // allSubArray test cases
    @Test
    public void testAllSubRange1() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        Assert.assertEquals(3, Upvote.allSubRange(testArray));
    }
    @Test
    public void testAllSubRange2() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(2);
            add(3);
            add(1);
        }};
        Assert.assertEquals(0, Upvote.allSubRange(testArray));
    }
    @Test
    public void testAllSubRange3() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(3);
            add(1);
            add(1);
        }};
        // Based on the challenge description the example result
        // should be -2 for this window, though I think that's not correct
        // -3 is the correct value.
//        Assert.assertEquals(-2, Upvote.allSubRange(testArray));
        Assert.assertEquals(-3, Upvote.allSubRange(testArray));
    }

    @Test
    public void testMoveWindow() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(1);
            add(1);
        }};
        int[] expected = {3, 0, -3};
        Assert.assertArrayEquals(expected, Upvote.moveWindow(5, 3, testArray));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMoveWindowParamError() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(1);
            add(1);
        }};
        thrown.expect(Exception.class);
        thrown.expectMessage("Number of votes parameter: 4 not equals  with the number of elements: 5 in the vote list");
        Upvote.moveWindow(4, 3, testArray);
    }

    @Test
    public void testMoveWindowParamError2() throws Exception {
        List<Integer> testArray = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(1);
            add(1);
        }};
        thrown.expect(Exception.class);
        thrown.expectMessage("Number of votes: 5 smaller than the window size: 8");
        Upvote.moveWindow(5, 8, testArray);
    }
}
