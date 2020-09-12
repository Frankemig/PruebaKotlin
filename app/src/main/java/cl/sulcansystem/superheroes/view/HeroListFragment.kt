package cl.sulcansystem.superheroes.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.sulcansystem.superheroes.R
import cl.sulcansystem.superheroes.model.HeroMini
import kotlinx.android.synthetic.main.fragment_hero_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HeroListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var heroList = ArrayList<HeroMini>()
    private lateinit var adapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            HeroListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HeroAdapter(heroList)
        heroRecycler.adapter = adapter
        val heroViewModel : HeroViewModel by activityViewModels()

        heroViewModel.listHero.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })
        adapter.heroSelected.observe(viewLifecycleOwner, Observer {
            Log.d("lifeCycleOwner", "heroe seleccionado $it")

        })
    }
}


