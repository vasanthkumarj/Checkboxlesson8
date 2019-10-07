package vk.com.checkbox_lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> selectionList = new ArrayList<>();
    private CheckBox fruitCheckBox;
    private TextView resultView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.result);
    }

    public void selectFruits(final View view) {
        fruitCheckBox = (CheckBox) view;
        boolean checked = fruitCheckBox.isChecked();
        if (checked) {
            selectionList.add(fruitCheckBox.getText().toString());
        } else {
            selectionList.remove(fruitCheckBox.getText().toString());
        }

    }

    public void showResult(final View view) {
        Collections.sort(selectionList);
        final StringBuilder resultBuilder = new StringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            selectionList.forEach(fruit -> resultBuilder.append(fruit).append(" "));
        } else {
            for (String fruits : selectionList) {
                resultBuilder.append(fruits).append(" ");
            }
        }

        resultView.setText(resultBuilder.toString());

    }
}
