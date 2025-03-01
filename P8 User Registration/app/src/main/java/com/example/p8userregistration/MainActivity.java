package com.example.p8userregistration;
import com.example.p8userregistration.R;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    private EditText etUserName, etPassword, etAddress, etAge;
    private RadioGroup rgGender;
    private Button btnSelectDOB, btnSubmit;
    private TextView tvSubmittedData;
    private String selectedDOB = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etAddress = findViewById(R.id.etAddress);
        etAge = findViewById(R.id.etAge);
        rgGender = findViewById(R.id.rgGender);
        btnSelectDOB = findViewById(R.id.btnSelectDOB);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvSubmittedData = findViewById(R.id.tvSubmittedData);
        btnSelectDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear,
                                                                        selectedMonth, selectedDay) -> {
            selectedDOB = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            btnSelectDOB.setText(selectedDOB);
        }, year, month, day);
        datePickerDialog.show();
    }
    private void submitForm() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        String address = etAddress.getText().toString();
        String age = etAge.getText().toString();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender != null ? selectedGender.getText().toString() : "";
        if (userName.isEmpty() || password.isEmpty() || address.isEmpty() || age.isEmpty() ||
                selectedDOB.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        String submittedText = "User Name: " + userName + "\n" +
                "Password: " + password + "\n" +
                "Address: " + address + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n" +
                "Date of Birth: " + selectedDOB;
        tvSubmittedData.setText(submittedText);
        tvSubmittedData.setVisibility(View.VISIBLE);
    }
}