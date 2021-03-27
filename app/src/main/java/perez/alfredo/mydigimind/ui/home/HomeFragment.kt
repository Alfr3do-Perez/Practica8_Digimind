package perez.alfredo.mydigimind.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import perez.alfredo.mydigimind.R
import perez.alfredo.mydigimind.Recordatorio

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root:View = inflater.inflate(R.layout.fragment_home, container, false)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {

            if(arguments != null ){
                var recordatorio = requireArguments().getSerializable("recordatorio");
                recordatorios.add(recordatorio as Recordatorio);
            }

            Log.d("prueba", "Se abrio el home");
            var gridview:GridView = root.findViewById(R.id.tabla_recordatorios) as GridView;
            var adapter:RecordatoriosAdapter = RecordatoriosAdapter(root.context, recordatorios);
            gridview.adapter = adapter;
        //})
        return root
    }


    public class RecordatoriosAdapter: BaseAdapter {
        var recordatorios = ArrayList<Recordatorio>();
        var context: Context?= null;

        constructor(context: Context, recordatorios: ArrayList<Recordatorio>){
            this.context = context;
            this.recordatorios = recordatorios
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var recordatorio = recordatorios[position];
            var inflator = LayoutInflater.from(context);
            var vista = inflator.inflate(R.layout.recordatorio, null);

            var nombre_recordatorio:TextView = vista.findViewById(R.id.nombre_recordatorio) as TextView;
            var dias_recordatorio:TextView = vista.findViewById(R.id.dias_recordatorio) as TextView;
            var hora_recordatorio:TextView = vista.findViewById(R.id.hora_recordatorio) as TextView;

            nombre_recordatorio.setText(recordatorio.nombre);
            dias_recordatorio.setText(recordatorio.dias);
            hora_recordatorio.setText(recordatorio.tiempo);

            return vista
        }

        override fun getItem(position: Int): Any {
            return recordatorios[position];
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getCount(): Int {
            return recordatorios.size;
        }


    }

    companion object {
        var recordatorios = ArrayList<Recordatorio>();
    }
}