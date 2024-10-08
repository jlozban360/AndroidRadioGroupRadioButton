package es.iesoretania.radiogroupradiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.radiogroupradiobutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate( getLayoutInflater( ) );
        setContentView( binding.getRoot( ) );

        binding.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( numberNotEmpty( ) )
                    calcularSuma();
                else
                    Toast.makeText( MainActivity.this, "Rellena los números", Toast.LENGTH_SHORT ).show( );
            }
        });

        binding.radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( numberNotEmpty( ) )
                    calcularResta();
                else
                    Toast.makeText( MainActivity.this, "Rellena los números", Toast.LENGTH_SHORT ).show( );
            }
        });

        binding.radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( numberNotEmpty( ) )
                    calcularMultiplicacion();
                else
                    Toast.makeText( MainActivity.this, "Rellena los números", Toast.LENGTH_SHORT ).show( );
            }
        });

        binding.radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( numberNotEmpty( ) )
                    calcularDivision();
                else
                    Toast.makeText( MainActivity.this, "Rellena los números", Toast.LENGTH_SHORT ).show( );
            }
        });

    }

    private Boolean numberNotEmpty( )
    {
        String valor1Str = binding.editTextNumberValue1.getText().toString();
        String valor2Str = binding.editTextNumberValue2.getText().toString();

        return !valor1Str.isEmpty() && !valor2Str.isEmpty();
    }

    private void calcularSuma() {
        String valor1Str = binding.editTextNumberValue1.getText().toString();
        String valor2Str = binding.editTextNumberValue2.getText().toString();

        double resultado = Double.parseDouble(valor1Str) + Double.parseDouble(valor2Str);
        binding.textViewResultado.setText(String.valueOf(resultado));
    }

    private void calcularResta() {
        String valor1Str = binding.editTextNumberValue1.getText().toString();
        String valor2Str = binding.editTextNumberValue2.getText().toString();

        double resultado = Double.parseDouble(valor1Str) - Double.parseDouble(valor2Str);
        binding.textViewResultado.setText(String.valueOf(resultado));
    }

    private void calcularMultiplicacion() {
        String valor1Str = binding.editTextNumberValue1.getText().toString();
        String valor2Str = binding.editTextNumberValue2.getText().toString();

        double resultado = Double.parseDouble(valor1Str) * Double.parseDouble(valor2Str);
        binding.textViewResultado.setText(String.valueOf(resultado));
    }

    private void calcularDivision() {
        String valor1Str = binding.editTextNumberValue1.getText().toString();
        String valor2Str = binding.editTextNumberValue2.getText().toString();

        double resultado = Double.parseDouble(valor1Str) / Double.parseDouble(valor2Str);
        binding.textViewResultado.setText(String.valueOf(resultado));
    }
}