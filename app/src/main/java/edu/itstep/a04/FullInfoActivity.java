package edu.itstep.a04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import edu.itstep.a04.databinding.ActivityFullInfoBinding;
public class FullInfoActivity extends AppCompatActivity {

    private ActivityFullInfoBinding binding;
    private Contact editedContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the contact position from the intent
        int contactPosition = getIntent().getIntExtra("contact_position", -1);

        if (contactPosition != -1) {
            // Get the contact at the specified position
            editedContact = ContactStorage.getContact(contactPosition);

            // Initialize views and set initial data
            binding.ivLogo.setImageResource(editedContact.getAvatar());
            binding.etFirstName.setText(editedContact.getFirstName());
            binding.etLastName.setText(editedContact.getLastName());
            binding.etEmail.setText(editedContact.getEmail());
            binding.etPhone.setText(editedContact.getPhone());

            // Set onClickListener for the save changes button
            binding.btnApply.setOnClickListener(view -> onSaveChangesClicked(editedContact));
        }
    }



    private void onSaveChangesClicked(Contact contact) {
        // Update the contact data
        contact.setFirstName(binding.etFirstName.getText().toString());
        contact.setLastName(binding.etLastName.getText().toString());
        contact.setEmail(binding.etEmail.getText().toString());
        contact.setAvatar(R.drawable.android); // Set the appropriate avatar

        // You can also update the contact in the ContactStorage here if needed

        // Finish the activity
        setResult(Activity.RESULT_OK);
        finish();
    }
}


