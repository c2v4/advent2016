package t4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class t4Test {
    @Test fun realTest() {
        assertTrue { real("aaaaa-bbb-z-y-x-123[abxyz]") }
    }

    @Test fun realNameTest() {
        assertEquals("very encrypted name ", realName("qzmt-zixmtkozy-ivhz-343"))
    }
}