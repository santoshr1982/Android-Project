package list.ado.to.rsantosh.com.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.MonthlyAdapter;
import list.ado.to.rsantosh.com.todolist.Model.MonthlyModel;

public class MonthlyToDoList extends AppCompatActivity {

    private ArrayList<MonthlyModel> mMonthlyArray;
    private MonthlyAdapter mMonthlyadapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_to_do_list);

        mMonthlyArray = getData();
        mMonthlyadapter = new MonthlyAdapter(this,R.layout.item_monthly,mMonthlyArray);
        mListView = (ListView) findViewById(R.id.monthly_list);
        mListView.setAdapter(mMonthlyadapter);

    }

    private ArrayList<MonthlyModel> getData() {

        ArrayList<MonthlyModel> mMonthlyArray = new ArrayList<>();

        mMonthlyArray.add(new MonthlyModel("Phone Bill","21.06.2016","353"));
        mMonthlyArray.add(new MonthlyModel("Water Bill","15.06.2016","453"));
        mMonthlyArray.add(new MonthlyModel("Maid Salary","01.06.2016","1500"));
        mMonthlyArray.add(new MonthlyModel("Mobile Bill","27.06.2016","999"));
        mMonthlyArray.add(new MonthlyModel("T V DTH","05.06.2016","1000"));

        return mMonthlyArray;
    }
}
