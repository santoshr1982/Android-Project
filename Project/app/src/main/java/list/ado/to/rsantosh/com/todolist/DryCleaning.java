package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.DryCleaningAdapter;
import list.ado.to.rsantosh.com.todolist.Model.DryCleaningModel;

public class DryCleaning extends AppCompatActivity {

    private ArrayList<DryCleaningModel> mDryCleaning;
    private DryCleaningAdapter mDclAdapt;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry_cleaning);

        mDryCleaning = getData();

        mDclAdapt =new DryCleaningAdapter(this,R.layout.item_drycleaning,mDryCleaning);

        mListView = (ListView) findViewById(R.id.dry_cleaning_list);

        mListView.setAdapter(mDclAdapt);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent New = new Intent(getApplicationContext(),DetailEditDelete.class);
                New.putExtra("NAME",mDryCleaning.get(i).strNameOfCloth);
                New.putExtra("DATE",mDryCleaning.get(i).strDateOfGiving);

                startActivity(New);

            }
        });

    }

    private ArrayList<DryCleaningModel> getData() {

        ArrayList<DryCleaningModel> mDryCleaning = new ArrayList<>();

        mDryCleaning.add(new DryCleaningModel("Shirt","12nos","30.05.2016","31.05.2016"));
        mDryCleaning.add(new DryCleaningModel("Pant","12nos","30.05.2016","31.05.2016"));
        mDryCleaning.add(new DryCleaningModel("T-Shirt","12nos","30.05.2016","31.05.2016"));

        return mDryCleaning;
    }
}
