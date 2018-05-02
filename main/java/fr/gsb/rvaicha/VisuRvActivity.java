package fr.gsb.rvaicha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fr.gsb.rvaicha.modeles.ModeleGsb;




public class VisuRvActivity extends AppCompatActivity {

    Button VisualiserRV ;
    Integer numero ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visu_rv);







    }








    public void VisualiserRV(View vue){




        Intent intention = new Intent(this, VisuRvActivity.class);

        Bundle paquet = new Bundle();



        intention.putExtras( paquet );


        ModeleGsb.getInstance().getVisualiserRV(  numero );




    }



}

