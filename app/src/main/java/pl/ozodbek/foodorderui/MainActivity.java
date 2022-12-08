package pl.ozodbek.foodorderui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import pl.ozodbek.foodorderui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.orderbutton.setOnClickListener(v -> {
            Toast.makeText(this, "You have ordered", Toast.LENGTH_SHORT).show();
        });
    }
}