package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    public void incriment(View view) {

        quantity = quantity + 1;
        displayQunatity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQunatity(quantity);
    }

    public void submitOrder(View view) {
        EditText namefield = (EditText) findViewById(R.id.name_field);
        String name = namefield.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String orderMessage = createOrderSummery(name, price, hasWhippedCream, hasChocolate);
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

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        int price = quantity * basePrice;
        return price;
    }

    private String createOrderSummery(String name, int price, boolean addWhippedCream, boolean addchocolate) {
        String priceMessage = "Name:" + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addchocolate;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\ntotal: $" + price;
        priceMessage += "\n thank you";
        return priceMessage;
    }
}