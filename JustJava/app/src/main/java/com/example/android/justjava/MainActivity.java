package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        quantity += 1;
        display(quantity);
    }

    public void decrement(View view){
        quantity -= 1;
        display(quantity);
    }

    public void summitOrder(View view){
        int price = quantity * 5;
        displayString(createOrderSummary(price));
    }

    private String createOrderSummary(int price){
        return "Name: Kaptain Kunal\nQuantity: " + quantity
                + "\nTotal: $" + price + "\nThank you!";
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayString(String words) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(words);
    }
}