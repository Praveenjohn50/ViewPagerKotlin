package program.sample.praveen.view_pager_example

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Praveen John on 23,January,2019
 */
class ThirdFragment : Fragment() {
    private var title: String? = null
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments!!.getInt("data3", 0)
        title = arguments!!.getString("title3")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //Start Fragment by new Instance
    companion object {

        fun newInstance(page: Int, title: String): ThirdFragment {
            val fragmentFirst = ThirdFragment()
            val args = Bundle()
            args.putInt("data3", page)
            args.putString("title3", title)
            fragmentFirst.arguments = args

            return fragmentFirst
        }
    }
}