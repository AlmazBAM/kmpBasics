import android.content.Context
import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test
import org.junit.runner.manipulation.Ordering

class SampleTest {

    @Test
    fun testPackageName() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        assertThat(context.packageName).isEqualTo("com.bagmanov.helloworldkmp")
    }
}