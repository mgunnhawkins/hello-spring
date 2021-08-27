  
import org.junit.Test;  
  
import static org.junit.Assert.\*;  
import static org.junit.Assert.assertFalse;  
import static org.junit.Assert.assertEquals;  
import static org.junit.Assert.assertTrue;  
import static org.junit.Assert.assertNull;  
  
  
public class BalancedBracketsTest {  
  
    //TODO: add tests here  
 @Test  
 public void emptyTest() {  
        assertEquals(true, true);  
 }  
  
    @Test  
 public void onlyBracketsReturnsTrue() {  
        assertTrue(BalancedBrackets.hasBalancedBrackets("\[\]"));  
 }  
  
    //brackets in wrong order should return false ex:  Launch\]Code\[  
 @Test  
 public void bracketsInWrongOrderNoTextReturnFalse() {  
        assertFalse(main.BalancedBrackets.hasBalancedBrackets("\[\]"));  
 }  
  
  
    //empty or no brackets should return true  
 //only one bracket \[ should return false //only one bracket \] should return false //only one bracket \[ with text should return false //only one bracket \] with text should return false //\[ text \] should return true // text \[ aasetjk \] should return true // text \[\] is true //\[\] text should return true