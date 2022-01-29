package com.preethampm.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.preethampm.bankingapplication.data.Client;
import com.preethampm.bankingapplication.database.UserHelper;
import com.preethampm.bankingapplication.listadapter.UserListAdapter;
import com.preethampm.bankingapplication.database.UserContract.UserEntry;

import java.util.ArrayList;

public class UsersList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Client> clientArrayList;

    // Databaseb
    private UserHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        // Create ArrayList of Users
        clientArrayList = new ArrayList<Client>();

        // Create Table in the Database
        dbHelper = new UserHelper(this);

        // Read Data from DataBase
        displayDatabaseInfo();

        // Show list of items
        recyclerView = findViewById(R.id.all_users_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new UserListAdapter(this, clientArrayList);
        recyclerView.setAdapter(myAdapter);
    }

    private void displayDatabaseInfo() {
        clientArrayList.clear();

        Cursor cursor = new UserHelper(this).readAllData();

        int phoneNoColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_PHONE_NO);
        int emailColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_EMAIL);
        int ifscCodeColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_IFSC_CODE);
        int accountNumberColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_ACCOUNT_NUMBER);
        int nameColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_NAME);
        int accountBalanceColumnIndex = cursor.getColumnIndex(UserEntry.COLUMN_USER_ACCOUNT_BALANCE);

        while (cursor.moveToNext()) {
            String currentName = cursor.getString(nameColumnIndex);
            int accountNumber = cursor.getInt(accountNumberColumnIndex);
            String email = cursor.getString(emailColumnIndex);
            String phoneNumber = cursor.getString(phoneNoColumnIndex);
            String ifscCode = cursor.getString(ifscCodeColumnIndex);
            int accountBalance = cursor.getInt(accountBalanceColumnIndex);

            // Display the values from each column of the current row in the cursor in the TextView
            //clientArrayList.add(new Client(currentName, accountNumber, phoneNumber, ifscCode, accountBalance, email));
        }
    }
}