package fr.gsb.rvaicha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import fr.gsb.rvaicha.technique.Session;

public class MenuRvActivity extends AppCompatActivity {


    TextView tvErreur ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);
        System.out.println( "Menu> " + Session.getSession().getLeVisiteur() ) ;




    }


    public void consulter(View vue ){
            //tvErreur.setText("voici votre rapport de visite " );

            Intent intention = new Intent( this , RechercheRvActivity.class ) ;
            startActivity( intention );// c v m'enmener vers la vue RechercheRvActivity qui me demande l'annee et le moi


    }



    public void saisir( View vue ){
       Intent intention = new Intent( this , SaisieRvActivity.class ) ;
      startActivity( intention );//c v m'enmener vers la vue SaisieRvActivity (faut regarder le shema sur porteVue slam 5 tt a la fin)

    }

}


