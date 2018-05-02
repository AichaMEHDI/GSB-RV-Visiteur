package fr.gsb.rvaicha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.gsb.rvaicha.entites.Visiteur;
import fr.gsb.rvaicha.modeles.ModeleGsb;
import fr.gsb.rvaicha.technique.Session;


public class MainActivity extends AppCompatActivity {

    TextView tvErreur ;
    EditText etMatricule ;
    EditText etMDP ;


    private ModeleGsb modele = ModeleGsb.getInstance();
    private Visiteur visi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvErreur = (TextView) findViewById( R.id.tvErreur) ;
        etMatricule = (EditText) findViewById( R.id.etMatricule) ;
        etMDP = (EditText) findViewById( R.id.etMDP) ;

    }


    public void valider( View vue ){

        String matricule =  etMatricule.getText().toString();//on recupere le matricule qui est saisie par l'utilisateur
        String mdp =  etMDP.getText().toString();//on recupere le mdp saisie par l'utilisateur

        boolean ok = Session.ouvrir(matricule , mdp) ; // je cree une variable boolean qui v dans la classe session et on recupere matricule et mdp de la BD

        if(ok == true ){// ici je vérifie et je saisie 'le nom et le prenom 'si les données saisie par l'utilisateur sont conforme avec la le model  et j'affiche un message derreure quand ca marche pas
            tvErreur.setText("Bonjour " + Session.getSession().getLeVisiteur().getPrenom() + " " + Session.getSession().getLeVisiteur().getNom());
            // Basculer sur Activité Menu

            Intent intention = new Intent( this , MenuRvActivity.class ) ;
            startActivity( intention );// je cree une vue et ici je derige ver la vue MenuRvActivity

        }
        else {
            tvErreur.setText("Connexion impossible");


        }
       // tvErreur.setText(mdp);


    }



    public void annuler( View vue ){// dans le button annuler j'affiche rien une chaine vide

        etMatricule.setText("");
        etMDP.setText("");
    }








}
