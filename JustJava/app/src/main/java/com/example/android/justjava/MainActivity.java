package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    String wc = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        if (quantity == 100) Toast.makeText(getApplicationContext(),
                    "you can order at most 100 cups of coffee.", Toast.LENGTH_SHORT).show();
        else quantity += 1;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity == 1) Toast.makeText(getApplicationContext(),
                    "you should at least order 1 cup of coffee.", Toast.LENGTH_SHORT).show();
        else quantity -= 1;
        display(quantity);
    }

    public void summitOrder(View view){
        EditText nameInput = (EditText) findViewById(R.id.name);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{});
        i.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + nameInput.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT   , createOrderSummary());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private String createOrderSummary(){
        String cc = "false";
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        EditText nameInput = (EditText) findViewById(R.id.name);
        int pricePerCup = 5;
        if (ChocolateCheckBox.isChecked()) {
            cc = "true";
            pricePerCup += 2;
        }
        if (wc == "true") pricePerCup += 1;
        String name = nameInput.getText().toString();
        return "Name: "+ name + "\nAdd whipped cream? " + wc + "\nAdd chocolate? " + cc
                +"\nQuantity: " + quantity + "\nTotal: $" + pricePerCup * quantity + "\nThank you!";
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayString(String words) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(words);
    }

    public void checked(View view){
        if (((CheckBox) view).isChecked()) wc = "true";
        else wc = "false";
    }
}