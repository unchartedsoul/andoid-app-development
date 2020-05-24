package com.example.justjava;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.TextView;
        import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberofcoffe =2;

    public void incriment(View view) {

        numberofcoffe = numberofcoffe + 1 ;
        display(numberofcoffe);}

    public void decrement(View view) {
        numberofcoffe =numberofcoffe -1;
        display(numberofcoffe);}

    public void submitOrder(View view) {
        int price =numberofcoffe*5;
        String priceMessage = "Total: $" + price+"\n Thank You!";
        displayMessage(priceMessage);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quntity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}