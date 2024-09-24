import android.content.Context
import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab_week_4.CafeDetailFragment
import com.example.lab_week_4.R

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)
class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val context: Context // Add context as a parameter
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    // Define the number of tabs
    override fun getItemCount(): Int = TABS_FIXED.size

    // Create a new fragment instance for each tab
    override fun createFragment(position: Int): Fragment {
        val cafeDescription = when (position) {
            0 -> context.getString(R.string.starbucks_desc)
            1 -> context.getString(R.string.janjijiwa_desc)
            2 -> context.getString(R.string.kopikenangan_desc)
            else -> throw IllegalStateException("Invalid position: $position")
        }
        return CafeDetailFragment.newInstance(cafeDescription)
    }
}
