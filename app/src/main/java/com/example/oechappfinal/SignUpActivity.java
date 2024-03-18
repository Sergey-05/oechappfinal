package com.example.oechappfinal;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Находим иконку видимости пароля и устанавливаем для нее слушатель щелчка
        ImageView passwordVisibilityToggle = findViewById(R.id.password_visibility_toggle);
        ImageView confirmPasswordVisibilityToggle = findViewById(R.id.confirm_password_visibility_toggle);

        passwordVisibilityToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility((ImageView) v, R.id.edit_text_password);
            }
        });

        confirmPasswordVisibilityToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility((ImageView) v, R.id.edit_text_confirm_password);
            }
        });
    }

    private void togglePasswordVisibility(ImageView imageView, int editTextId) {
        EditText editText = findViewById(editTextId);
        if (editText != null) {
            int inputType = editText.getInputType();
            if (inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageView.setImageResource(R.drawable.eyeslash); // Change icon to show hidden password
            } else {
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageView.setImageResource(R.drawable.eye); // Change icon to show visible password
            }
            editText.setSelection(editText.getText().length()); // Keep cursor at the end of the text
        }
    }
}