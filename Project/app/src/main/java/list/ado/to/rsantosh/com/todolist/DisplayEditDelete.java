package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.DisplayAdapter;
//import list.ado.to.rsantosh.com.todolist.Helper.PurchaseDbHelper;
import list.ado.to.rsantosh.com.todolist.Helper.PurchaseDbHelper;
import list.ado.to.rsantosh.com.todolist.Model.ListDetails;

public class DisplayEditDelete extends AppCompatActivity {


    //Declaration Section.
    //Declaration for array list.
    private ArrayList<ListDetails> mListDetails;
    //Declaration for List view.
    private ListView mListView;
    //Declaration for DBHelper;
    private PurchaseDbHelper mDbhelper;
    //Declaration for Adapter.
    private DisplayAdapter mDisplayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_edit_delete);

        //Initialization of list view.
        mListView = (ListView) findViewById(R.id.details);

        //Initialization of Array list.
        mListDetails = new ArrayList<>();

        //Initialisation of DBHelper.
        mDbhelper = new PurchaseDbHelper(getApplicationContext());

        //Getting values in to array.
        mListDetails = mDbhelper.getData();

        //Initialisation of Adapter;
        mDisplayAdapter = new DisplayAdapter(this,R.layout.item_display,mListDetails);

        //Binding adapter with list view.
        mListView.setAdapter(mDisplayAdapter);

        //Code for click event on list view.
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //This code has been written to open detailed description UI;
                Intent New = new Intent(getApplicationContext(),DetailEditDelete.class);

                //This code has been written to pass the values from this UI to the detail UI.
                New.putExtra("NAME",mListDetails.get(i).strProductName);
                New.putExtra("ID",String.valueOf(mListDetails.get(i).Id));
                Toast.makeText(getApplicationContext()," "+ mListDetails.get(i).Id,Toast.LENGTH_SHORT).show();

                //This line of code will start the activity Intent.
                startActivity(New);
                finish();

            }
        });

    }
}
