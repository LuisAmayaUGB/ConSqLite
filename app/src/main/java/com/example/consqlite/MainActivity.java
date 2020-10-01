package com.example.consqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText codigo, descripcion, precio;
    Button guardar,buscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        codigo=(EditText)findViewById(R.id.codigo);
        descripcion=(EditText)findViewById(R.id.descripcion);
        precio=(EditText)findViewById(R.id.precio);
        guardar=(Button)findViewById(R.id.guardar);
        buscar=(Button)findViewById(R.id.buscar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db db= new db(getApplicationContext(),null,null,1);
                String Codigo = codigo.getText().toString();
                String Descripcion = descripcion.getText().toString();
                String Precio = precio.getText().toString();
                String mensaje =db.guardar(Codigo,Descripcion,Precio);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(),Buscar_Eliminar_Actualizar.class);
                startActivity(intento);
            }
        });





    }
}