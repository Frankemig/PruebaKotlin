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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_heroe_detail.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HeroeDetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        val heroViewModel: HeroeViewModel by activityViewModels()
        heroViewModel.getDetails(param1!!).observe(viewLifecycleOwner, Observer {
            Log.d("Parametro Observado", "${it!!.toString()}")
            Picasso.get().load(it!!.images.md).into(imageDetail)
            txt_name_hero_detail.text = it!!.name

            btnappearance.setOnClickListener{
                Log.d("btn", "Estás Entrando a Appearance")
            }
            btnbiography.setOnClickListener{
                Log.d("btn", "Estás Entrando a Biography")
            }
            btnpowerstats.setOnClickListener{
                Log.d("btn", "Estás Entrando a Powerstats")
            }

        })
        return inflater.inflate(R.layout.fragment_heroe_detail, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeroeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}