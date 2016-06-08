package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.MaidAdapter;
import list.ado.to.rsantosh.com.todolist.Model.MaidModel;

public class MaidWorking extends AppCompatActivity {

    private ArrayList<MaidModel> mMaidArray;
    private MaidAdapter mMaidAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_working);

        mMaidArray = getData();
        mMaidAdapter = new MaidAdapter(this,R.layout.format_maid,mMaidArray);
        mListView = (ListView) findViewById(R.id.maid);
        mListView.setAdapter(mMaidAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent New = new Intent(getApplicationContext(),DetailEditDelete.class);
                New.putExtra("NAME",mMaidArray.get(i).strName);
                New.putExtra("DATE",mMaidArray.get(i).strDayOfWork);

                startActivity(New);

            }
        });


    }

    private ArrayList<MaidModel> getData() {

        mMaidArray = new ArrayList<>();

        mMaidArray.add(new MaidModel("Girija","Monday","5:30pm"));
        mMaidArray.add(new MaidModel("Vasuda","Tuesday","6:30pm"));

        return mMaidArray;
    }
}
