package com.example.addlistproductv1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        layout = findViewById(R.id.container);

        buildDialog();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        final EditText id = view.findViewById(R.id.idproductEdit);
        final EditText name = view.findViewById(R.id.nameEdit);
        final EditText price = view.findViewById(R.id.priceEdit);
        final EditText quantity = view.findViewById(R.id.quantityEdit);
        final EditText maker = view.findViewById(R.id.makerEdit);

        builder.setView(view);
        builder.setTitle("Enter name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(id.getText().toString(),name.getText().toString(),price.getText().toString(),quantity.getText().toString(),maker.getText().toString());

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }

    private void addCard(String id,String name,String price,String quantity,String maker) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);
        TextView idView = view.findViewById(R.id.idproduct);
        TextView nameView = view.findViewById(R.id.name);
        TextView priceView = view.findViewById(R.id.price);
        TextView quantityView = view.findViewById(R.id.quantity);
        TextView makerView = view.findViewById(R.id.maker);

        idView.setText("Product ID: " + id);
        nameView.setText("name: " +name);
        priceView.setText("price: " +price);
        quantityView.setText("quantity: " +quantity);
        makerView.setText("maker: " +maker);


        layout.addView(view);
    }
}