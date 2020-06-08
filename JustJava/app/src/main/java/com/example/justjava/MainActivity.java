package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void incriment(View view) {
        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do

            return;
        }
        quantity = quantity + 1;
        displayQunatity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQunatity(quantity);
    }

    public void submitOrder(View view) {
        EditText namefield = findViewById(R.id.name_field);
        String name = namefield.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String orderMessage = createOrderSummery(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for" + name);
        intent.putExtra(Intent.EXTRA_TEXT, orderMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


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
        String priceMessage = getString(R.string.order_summery_name, name);
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addchocolate;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\ntotal: $" + price;
        priceMessage += "\n " + getString(R.string.thank_you);
        return priceMessage;
    }
}