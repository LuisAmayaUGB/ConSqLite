package com.example.consqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar_Eliminar_Actualizar extends AppCompatActivity {

    EditText codigo, descripcion, precio;
    Button Bbuscar,BEliminar,BActualizar,BLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar__eliminar__actualizar);


        codigo=(EditText) findViewById(R.id.codigo);
        descripcion=(EditText) findViewById(R.id.descripcion);
        precio=(EditText) findViewById(R.id.precio);
        Bbuscar=(Button)findViewById(R.id.Bbuscar);
        BEliminar=(Button)findViewById(R.id.BEliminar);
        BActualizar=(Button)findViewById(R.id.BActualizar);
        BLista=(Button)findViewById(R.id.blista);


        Bbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db db = new db(getApplicationContext(),null,null,1);
                String buscar = codigo.getText().toString();
                String[] datos;
                datos=db.buscar_reg(buscar);
                codigo.setText(datos[0]);
                descripcion.setText(datos[1]);
                precio.setText(datos[2]);

                Toast.makeText(getApplicationContext(),datos[2], Toast.LENGTH_SHORT).show();
            }
        });
        BEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db db = new db(getApplicationContext(),null,null,1);
                String Codigo = codigo.getText().toString();
                String mensaje =db.eliminar(Codigo);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });
        BActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db db = new db(getApplicationContext(),null,null,1);
                String Codigo = codigo.getText().toString();
                String Descripcion = descripcion.getText().toString();
                String Precio = precio.getText().toString();

                String Mensaje =db.actualizar(Codigo, Descripcion, Precio);
                Toast.makeText(getApplicationContext(),Mensaje,Toast.LENGTH_SHORT).show();
            }
        });
        BLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(),listado.class);
                startActivity(intento);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}