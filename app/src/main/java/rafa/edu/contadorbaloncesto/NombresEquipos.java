package rafa.edu.contadorbaloncesto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Rafael NavarroPrieto on 25/11/2015.
 */
public class NombresEquipos extends Activity{
    EditText local,visitante;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nombres);

        local = (EditText) findViewById(R.id.nombrelocal);
        visitante = (EditText) findViewById(R.id.nombrevisitante);
        boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NombresEquipos.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("local",local.getText().toString());
                b.putString("visitante", visitante.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
                try {
                    this.finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }


            }
        });

    }
}
