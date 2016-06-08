package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import list.ado.to.rsantosh.com.todolist.Helper.PurchaseDbHelper;

public class DetailEditDelete extends AppCompatActivity implements View.OnClickListener {

    //Declaration Section.
    // Declaration of String value to accept the value parsed from the previous UI.
    private String mStrProductName;
    // Declaration of String value to accept the value parsed from the previous UI.
    private String mStrId;
    // Declaration of Edit Text.
    private EditText mEditTextID;
    // Declaration of Edit Text.
    private EditText mEditTextProductName;
    //Declaration of Button to Add a record to a DB.
    private Button mButtonAdd;
    //Declaration of Button to Modify a record to a DB.
    private Button mButtonModify;
    //Declaration of Button to reset a record to a DB.
    private Button mButtonReset;
    //Declaration of Button to cancel a record to a DB.
    private Button mButtonCancel;
    //Declaration of Button to Delete a record to a DB.
    private Button mButtonDelete;
    //Declaration of DBHelper.
    private PurchaseDbHelper mDBHelper;

    public int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edit_delete);

        //Initialisation of Edit text.
        mEditTextProductName = (EditText) findViewById(R.id.product_name);

        //Initialisation of DBHelper.
        mDBHelper = new PurchaseDbHelper(getApplicationContext());

        //Initialisation of add button.
        mButtonAdd = (Button) findViewById(R.id.add_button);
        //Initialisation of modify button.
        mButtonModify = (Button) findViewById(R.id.modify_button);
        //Initialisation of delete button.
        mButtonDelete = (Button) findViewById(R.id.delete_button);
        //Initialisation of Reset button.
        mButtonReset = (Button) findViewById(R.id.reset_button);
        //Initialisation of cancel button.
        mButtonCancel = (Button) findViewById(R.id.cancel_button);

        //Initialisation of get Intent.
        Intent get = getIntent();
        //Accepting the parsed value into another variable.
        mStrProductName = get.getStringExtra("NAME");
        //Displaying the value parsed in a edit text.
        mEditTextProductName.setText(mStrProductName);

        //Initialisation of same edit text with different variable.
        mEditTextID = (EditText) findViewById(R.id.pur_id);
        //Accepting the parsed value into another variable.
        mStrId = get.getStringExtra("ID");
        //Displaying the value parsed in a edit text.
        mEditTextID.setText(mStrId);

        //Initialisation of click event to all the button.
        mButtonAdd.setOnClickListener(this);
        mButtonModify.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this);
        mButtonReset.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.add_button:

                if(flag==0) {
                    mEditTextID.setText("");
                }
                mEditTextID.setEnabled(true);
                mEditTextProductName.setText("");
                mEditTextProductName.setEnabled(false);
                mButtonModify.setEnabled(false);
                mButtonDelete.setEnabled(false);
                //This method has been written to validate and insert a data to a table.
                addDataToTable();
                break;

            case R.id.modify_button:

                mButtonAdd.setEnabled(false);
                mButtonDelete.setEnabled(false);
                Modify();

                break;

            case R.id.delete_button:

                mButtonAdd.setEnabled(false);
                mButtonModify.setEnabled(false);
                Delete();

                break;

            case R.id.reset_button:

                //Set the edit text to blank.
                mEditTextID.setText("");
                //Set the edit text to blank.
                mEditTextProductName.setText("");
                //Set hint on the edit text.
                mEditTextID.setHint("Enter the name of Product to be purchased");
                //Enable edit text.
                mEditTextID.setEnabled(true);

                break;

            case R.id.cancel_button:

                //Close the UI.
                finish();

                break;

        }

    }

    private void Delete() {

        mDBHelper.DeleteRecord(Integer.parseInt(mEditTextID.getText().toString()));
        Toast.makeText(getApplicationContext(),"Record Deleted.",Toast.LENGTH_SHORT).show();
        Intent Back = new Intent(getApplicationContext(),DisplayEditDelete.class);
        startActivity(Back);
        finish();

    }

    private void Modify() {

        // Enabling the Edit tex to accept the product name.
        mEditTextProductName.setEnabled(true);

        // Validating the product name edit text.
        if( mEditTextProductName.getText().toString().trim().isEmpty()){

            // Displaying the message saying the edit text is blank.
            Toast.makeText(getApplicationContext(),"Name of the product can not be empty",Toast.LENGTH_SHORT).show();
            //Setting the flag to zero.
            flag = 0;

        }else {

            // To reset the flag.
            if(flag == 0){
                flag = 1;
            }
            else {
                //This code is to modify a record in the database.
                mDBHelper.Modify(Integer.parseInt(mEditTextID.getText().toString()), (mEditTextProductName.getText()).toString().trim(), "5:30pm", "09.06.2016");
                //Displays a message when the record is modified.
                Toast.makeText(getApplicationContext(), "Record modified.", Toast.LENGTH_SHORT).show();
                //Opens Display Edit Detail UI.
                Intent Open = new Intent(getApplicationContext(), DisplayEditDelete.class);
                //Closes the current UI.
                finish();
            }
        }
    }

    private void addDataToTable() {

        // This condition checks if the edit text is blank.
        if(mEditTextID.getText().toString().trim().isEmpty()){

            //Displays a toast message stating that the edt tex can not be empty.
            Toast.makeText(getApplicationContext(),"Enter name of the product to be purchased in the edit text." + mEditTextID.getText().toString().trim(),
                    Toast.LENGTH_SHORT).show();
            flag=1;
            //Else statement.
        }else{

            //Code to insert data in to table.
            mDBHelper.insertPurchase((mEditTextID.getText()).toString().trim(), "5:30", "06.06.2016");
            //Displays a toast message that the data has been added to the table.
            Toast.makeText(getApplicationContext(),"Product Added.",Toast.LENGTH_SHORT).show();
            flag=1;
            //Closes the UI.
            finish();

        }

    }

}
