package t7

import org.junit.Test
import t7.containsABBA
import t7.isTLS
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class t7plusTest {
    @Test fun tlsTest() {
        assertTrue{ isSSL("aba[bab]xyz")}
        assertFalse{ isSSL("xyx[xyx]xyx")}
        assertTrue{ isSSL("aaa[kek]eke")}
        assertTrue{ isSSL("zazbz[bzb]cdb")}
    }

    @Test fun getAbaTest(){
        assertEquals(listOf("aba"), getABAs("aba"))
        assertEquals(emptyList(), getABAs("abb"))
        assertEquals(listOf("bab","aba"), getABAs("baba"))
        assertEquals(listOf("aba"), getABAs("qsabass"))
        assertEquals(emptyList(), getABAs("ba"))
    }

}