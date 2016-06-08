package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.DetailsAdapter;
import list.ado.to.rsantosh.com.todolist.Model.Details;

public class DetailsActivity extends AppCompatActivity {

    private ArrayList<Details> mDetails;
    private DetailsAdapter mDetailsAdapt;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mDetails = getDetails();
        mListView = (ListView) findViewById(R.id.ToDoList);
        mDetailsAdapt = new DetailsAdapter(this,R.layout.item_display,mDetails);
        mListView.setAdapter(mDetailsAdapt);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:
                            Intent Display = new Intent(getApplicationContext(), DisplayEditDelete.class);
                            startActivity(Display);
                            break;

                    case 1:
                            Intent iDryCleaning = new Intent(getApplicationContext(),DryCleaning.class);
                            startActivity(iDryCleaning);
                            break;

                    case 2:
                            Intent iMaid = new Intent(getApplicationContext(),MaidWorking.class);
                            startActivity(iMaid);
                            break;
                }

            }
        });

    }

    private ArrayList<Details> getDetails() {

        ArrayList<Details> mDetails = new ArrayList<>();

        mDetails.add(new Details(R.drawable.grocery,"List of grocery to be purchased"));
        mDetails.add(new Details(R.drawable.drycleaning,"List of cloths to be dry cleaned"));
        mDetails.add(new Details(R.drawable.maid,"Maid working time"));

        return mDetails;
    }
}
