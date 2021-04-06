package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public  void CalcularPreco(View view){
        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Valida os campos digitados
        Boolean camposValidados = validarCampos (precoAlcool, precoGasolina);
        if( camposValidados ){
            //Convertendo string pra numeros
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );
            Double resultado = valorAlcool/valorGasolina;
            if ( resultado >= 0.7 ){
                textResultado.setText( "Utilize a gasolina" );
            }
            else {
                textResultado.setText( "Utilize o álcool" );
            }

        }
        else {
            textResultado.setText( "Preencha os preços primeiro!" );
        }

    }

    public Boolean validarCampos( String pAlcool, String pGasolina ){
        Boolean camposValidados = true;


        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }
        else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
