package pl.ozodbek.foodorderui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity<sum> extends AppCompatActivity {

    ImageView image1, check1, image2, check2, image3, check3,
            image4, check4, image5, check5, image6, check6, mainimage;

    TextView paymentsummary, priceofburger, burgername, receipe, weightofburger;
    Button orderButton;
    String[] names = {
            "Elk\nburger",
            "CheeseBurger",
            "Hamburger",
            "Steamed\nCheeseburger",
            "Slaw\nburger",
            "Le-Pigeon\nBurger"
    };

    int[]  weights = {
            280,
            190,
            320,
            300,
            250,
            380
    };
    private float sum = 0;
//    String.format("%.0f",sum);


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        check6 = findViewById(R.id.check6);


        mainimage = findViewById(R.id.mainimage);
        paymentsummary = findViewById(R.id.paymentsummary);
        orderButton = findViewById(R.id.orderbutton);
        priceofburger = findViewById(R.id.priceofburger);
        burgername = findViewById(R.id.burgername);
        receipe = findViewById(R.id.receipe);
        weightofburger = findViewById(R.id.weightofburger);


        image1.setOnClickListener(v -> {
            if (check1.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_1);
                check1.setVisibility(View.VISIBLE);
                sum += 7.99f;
                updatePrice();
                mainPriceChange(7.99);
                changeBurgerName(0);
                changeBUrgerWeights(0);
                receipe.setText(R.string.Decription1);
            } else {
                check1.setVisibility(View.INVISIBLE);
                sum -= 7.99f;
                updatePrice();
            }
        });

        image2.setOnClickListener(v -> {
            if (check2.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_2);
                check2.setVisibility(View.VISIBLE);
                sum += 9.99f;
                mainPriceChange(9.99);
                updatePrice();
                changeBurgerName(1);
                changeBUrgerWeights(1);
                receipe.setText(R.string.Decription2);

            } else {
                check2.setVisibility(View.INVISIBLE);
                sum -= 9.99f;
                updatePrice();
            }
        });
        image3.setOnClickListener(v -> {
            if (check3.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_3);
                check3.setVisibility(View.VISIBLE);
                sum += 11.99f;
                updatePrice();
                changeBurgerName(2);
                mainPriceChange(11.99);
                changeBUrgerWeights(2);
                receipe.setText(R.string.Decription3);

            } else {
                check3.setVisibility(View.INVISIBLE);
                sum -= 11.99f;
                updatePrice();
            }
        });
        image4.setOnClickListener(v -> {
            if (check4.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_4);
                check4.setVisibility(View.VISIBLE);
                sum += 17.99f;
                updatePrice();
                mainPriceChange(17.99);
                changeBurgerName(3);
                changeBUrgerWeights(3);
                receipe.setText(R.string.Decription4);

            } else {
                check4.setVisibility(View.INVISIBLE);
                sum -= 17.99f;
                updatePrice();
            }
        });
        image5.setOnClickListener(v -> {
            if (check5.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_5);
                check5.setVisibility(View.VISIBLE);
                sum += 12.99f;
                updatePrice();
                mainPriceChange(12.99);
                changeBurgerName(4);
                changeBUrgerWeights(4);
                receipe.setText(R.string.Decription5);

            } else {
                check5.setVisibility(View.INVISIBLE);
                sum -= 12.99f;
                updatePrice();
            }
        });
        image6.setOnClickListener(v -> {
            if (check6.getVisibility() != View.VISIBLE) {
                mainimage.setImageResource(R.drawable.img_6);
                check6.setVisibility(View.VISIBLE);
                sum += 20.99f;
                updatePrice();
                mainPriceChange(20.99);
                changeBurgerName(5);
                changeBUrgerWeights(5);
                receipe.setText(R.string.Decription6);
            } else {
                check6.setVisibility(View.INVISIBLE);
                sum -= 20.99f;
                updatePrice();
            }

        });

        orderButton.setOnClickListener(v -> {
           if (sum != 0){
               Toast.makeText(this, "Your orders have beeen received ✅", Toast.LENGTH_SHORT).show();
               sum = 0;
               mainimage.setImageResource(R.drawable.img_11);
               priceofburger.setText("$ cost");
               burgername.setText("Burger's\n           name");
               weightofburger.setText("Weight: ");
               receipe.setText(R.string.Decription0);
               check1.setVisibility(View.INVISIBLE);
               check2.setVisibility(View.INVISIBLE);
               check3.setVisibility(View.INVISIBLE);
               check4.setVisibility(View.INVISIBLE);
               check5.setVisibility(View.INVISIBLE);
               check6.setVisibility(View.INVISIBLE);
           }else
               Toast.makeText(this, "Please select at least one item 🛠", Toast.LENGTH_SHORT).show();
        });

    }

    private void changeBUrgerWeights(int i) {
        weightofburger.setText("Weight: " + weights[i] + "g");
    }

    private void changeBurgerName(int i) {
        burgername.setText(names[i]);
    }

    private void mainPriceChange(double v) {
        priceofburger.setText("$ " + v);
    }

    private void updatePrice() {
        paymentsummary.setText("$" + String.format("%.2f",sum));
    }
}