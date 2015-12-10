package rafa.edu.contadorbaloncesto;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    ImageButton l1,l2,l3,v1,v2,v3,resto1,resto2,reinicio;
    TextView marcadorLocal,marcadorVisitante,local,visitante;
    int puntuacionLocal = 0;
    int puntuacionVisitante = 0;
    boolean banderaNombres = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addEquipos:
                escribirNombres();
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void escribirNombres() {
        Intent act = new Intent(this, NombresEquipos.class);

        startActivity(act);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        marcadorLocal = (TextView)findViewById(R.id.local);
        marcadorVisitante = (TextView)findViewById(R.id.visitante);
        l1 = (ImageButton) findViewById(R.id.btnL1);
        l2 = (ImageButton) findViewById(R.id.btnL2);
        l3 = (ImageButton) findViewById(R.id.btnL3);
        v1 = (ImageButton) findViewById(R.id.btnV1);
        v2 = (ImageButton) findViewById(R.id.btnV2);
        v3 = (ImageButton) findViewById(R.id.btnV3);
        resto1 = (ImageButton) findViewById(R.id.btnFL);
        resto2 = (ImageButton) findViewById(R.id.btnFV);
        reinicio = (ImageButton) findViewById(R.id.btnReset);
        local = (TextView) findViewById(R.id.nlocal);
        visitante = (TextView) findViewById(R.id.nvisitante);

        asignarNombres();

    }

    private void asignarNombres() {


        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = this.getIntent().getExtras();
            local.setText(bundle.getString("local"));
            visitante.setText(bundle.getString("visitante"));
        }
    }

    public void reiniciar(View view){

        puntuacionLocal = 0;
        puntuacionVisitante= 0;
        marcadorLocal.setText(Integer.toString(puntuacionLocal));
        marcadorVisitante.setText(Integer.toString(puntuacionVisitante));

    }

    public void calcular(View view){

        puntuacionVisitante = Integer.parseInt(marcadorVisitante.getText().toString());
        puntuacionLocal = Integer.parseInt(marcadorLocal.getText().toString());

        if (view.getId() == R.id.btnL1)
            puntuacionLocal+=1;
        else if (view.getId() == R.id.btnL2)
            puntuacionLocal+=2;
        else if (view.getId() == R.id.btnL3)
            puntuacionLocal+=3;
        else if (view.getId() == R.id.btnV1)
            puntuacionVisitante+=1;
        else if (view.getId() == R.id.btnV2)
            puntuacionVisitante+=2;
        else if (view.getId() == R.id.btnV3)
            puntuacionVisitante+=3;
        else if (view.getId() == R.id.btnFL) {
            if (puntuacionLocal > 0) {
                --puntuacionLocal;
            }
        }
        else if (view.getId() == R.id.btnFV) {
                if (puntuacionVisitante > 0) {
                    --puntuacionVisitante;
                }
            }
        marcadorLocal.setText(Integer.toString(puntuacionLocal));
        marcadorVisitante.setText(Integer.toString(puntuacionVisitante));

    }



}
