package perez.alfredo.mydigimind.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import perez.alfredo.mydigimind.Carrito
import perez.alfredo.mydigimind.Comunicador
import perez.alfredo.mydigimind.R
import perez.alfredo.mydigimind.Recordatorio
import perez.alfredo.mydigimind.ui.home.HomeFragment

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var comunicador: Comunicador;

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root:View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            comunicador = activity as Comunicador
           val editTextNombre:EditText = root.findViewById(R.id.recordatorio_nombre) as EditText;
           val editTextHora:EditText = root.findViewById(R.id.recordatorio_hora) as EditText;
           val botonAgregarNota:Button = root.findViewById(R.id.recordatorio_boton) as Button;
           var recordatorio:Recordatorio;
           var bundle:Bundle;

            botonAgregarNota.setOnClickListener {
                if(!editTextNombre.text.toString().equals("") && !editTextHora.text.toString().equals("")){
                    recordatorio = Recordatorio(editTextNombre.text.toString(), "Error",editTextHora.text.toString());
                    comunicador.enviaroRecordatorio(recordatorio);
                }else{Toast.makeText(root.context, "You need to fill all the fields!", Toast.LENGTH_SHORT).show();}
            }

        //})
        return root
    }


}