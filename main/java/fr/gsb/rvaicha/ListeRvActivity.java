package fr.gsb.rvaicha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import fr.gsb.rvaicha.entites.RapportVisite;
import fr.gsb.rvaicha.modeles.ModeleGsb;
import fr.gsb.rvaicha.technique.Session;

public class ListeRvActivity extends AppCompatActivity {

    Spinner spListeRv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);






        spListeRv = (Spinner) findViewById( R.id.spListeRv);


        //String [ ] listeRv = { "Rapport1", "Rapport2","Rapport3","Rapport4","Rapport5" } ;

        Bundle paquet  = this.getIntent().getExtras();
        int mois = Integer.parseInt(paquet.getString("mois"));
        int annee = Integer.parseInt(paquet.getString("annee"));
        System.out.println(mois +"/"  + annee);
        System.out.println( Session.getSession().getLeVisiteur() ) ;


        List<RapportVisite> listeRv = ModeleGsb.getInstance().getRapportsVisites(Session.getSession().getLeVisiteur(),mois,annee);
        System.out.println(listeRv.size());

        ArrayAdapter<RapportVisite> aaListeRv = new ArrayAdapter<RapportVisite>( this , android.R.layout.simple_spinner_item, listeRv ) ;


        aaListeRv.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );



        spListeRv.setAdapter( aaListeRv );







    }



   public void validerRapport(View vue){


        // Intent intention = new Intent( this , ListerRvActivity.class ) ;

        Bundle paquet = new Bundle();
        paquet.putString( "listeRv", spListeRv.getSelectedItem().toString() );


        //intention.putExtras( paquet );

        // startActivity( intention );
    }




    public void VisualiserRV ( View vue ) {

        Intent intention = new Intent(this, VisuRvActivity.class);

        startActivity(intention);

    }





}
