package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;

    public void incriment(View view) {

        quantity = quantity + 1;
        displayQunatity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQunatity(quantity);
    }

    public void submitOrder(View view) {
        calculatePrice(quantity, 10);
        int order = calculatePrice(quantity, 10);
        String orderMessage = createOrderSummery(order);
        displayMessage(orderMessage);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderTextView = findViewById(R.id.order_text_view);
        orderTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQunatity(int number) {
        TextView quantityTextView = findViewById(R.id.quntity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(int quantuty, int pricrpapercup) {
        int order = quantity * pricrpapercup;
        return order;
    }

    private String createOrderSummery(int order) {
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage = priceMessage + "Quantity:" + quantity;
        priceMessage = priceMessage + "total: $" + order;
        priceMessage = priceMessage + "\n tahnk you";
        return priceMessage;
    }
}