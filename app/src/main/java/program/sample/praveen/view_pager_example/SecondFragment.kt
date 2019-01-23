package program.sample.praveen.view_pager_example

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Praveen John on 23,January,2019
 */
class SecondFragment : Fragment() {
    private var title: String? = null
    private var page: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments!!.getInt("data2", 0)
        title = arguments!!.getString("title2")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {

        fun newInstance(page: Int, title: String): SecondFragment {
            val fragmentFirst = SecondFragment()
            val args = Bundle()
            args.putInt("data2", page)
            args.putString("title2", title)

            fragmentFirst.arguments = args
            return fragmentFirst
        }
    }
}
