package perez.alfredo.mydigimind

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import perez.alfredo.mydigimind.ui.dashboard.DashboardFragment
import perez.alfredo.mydigimind.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), Comunicador {

    var carrito:Carrito = Carrito();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view);

        var navController = findNavController(R.id.host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard))
        navView.setupWithNavController(navController)




    }

    override fun enviaroRecordatorio(recordatorio: Recordatorio) {
        val bundle = Bundle();
        bundle.putSerializable("recordatorio",recordatorio);
        val transaction = supportFragmentManager.beginTransaction()
        var fragmentoTablero= HomeFragment();
        fragmentoTablero.arguments = bundle;

        transaction.replace(R.id.host_fragment, fragmentoTablero);
        transaction.addToBackStack(null);
        transaction.commit();



        /*val transaccion = supportFragmentManager.beginTransaction()
        var fragmento = Fragment()
        when (op) {
            1 -> fragmento = Fragment_primero()
            2 -> fragmento = Fragment_segundo()
            3 -> fragmento = Fragment_tercero()
        }

        transaccion.replace(R.id.contenedor, fragmento)
        transaccion.addToBackStack(null)
        transaccion.commit()*/
    }


}