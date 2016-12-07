package t7

import org.junit.Test
import t7.containsABBA
import t7.isTLS
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class t7Test {
    @Test fun tlsTest() {
        assertTrue { isTLS("abba[mnop]qrst") }
        assertTrue { isTLS("abcd[bdab]xyyx") }
        assertTrue { isTLS("ioxxoj[asdfgh]zxcvbn") }
        assertFalse { isTLS("abcd[bddb]xyyx") }
        assertFalse { isTLS("aaaa[qwer]tyui") }
    }

    @Test fun abbaTest(){
        assertTrue { containsABBA("abba") }
        assertTrue { containsABBA("xabbax") }
        assertTrue { containsABBA("asddsa") }
        assertTrue { containsABBA("566xxubbu") }
        assertTrue { containsABBA("assa7687") }
        assertFalse { containsABBA("aaaa") }
        assertFalse { containsABBA("abcd") }
        assertFalse { containsABBA("aabb") }
        assertFalse { containsABBA("aaaaaa") }
        assertFalse { containsABBA("aaaabb") }
    }

}