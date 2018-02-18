package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button boton, boton2, boton3;
    private TextView txtView;
    private Bitmap imagenDescarga;
    private ImageView Imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.button);
        txtView = findViewById(R.id.textView);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        Imagen = findViewById(R.id.imageView);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setText("Hola GitHub");
                Toast.makeText(MainActivity.this, "Se cambio el mensaje en el txtView", Toast.LENGTH_LONG).show();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setText("Hola profe");

            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new DescargarImagen().execute(new URL("https://vignette.wikia.nocookie.net/toontown/images/8/82/Toony_Toons.png/revision/latest?cb=20110313052410"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    class DescargarImagen extends AsyncTask<URL, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                imagenDescarga = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            } catch (Exception e) {
                Log.e("diplo", "error");
            }
            return imagenDescarga;
        }

        protected void onPostExecute(Bitmap bitmap) {
            Imagen.setImageBitmap(imagenDescarga);
            super.onPostExecute(bitmap);
        }
    }
}
