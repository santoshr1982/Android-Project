package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.MonthlyModel;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 01-06-2016.
 */
public class MonthlyAdapter extends ArrayAdapter {

    private ArrayList<MonthlyModel> mArray;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private TextView mTextView;

    public MonthlyAdapter(Context context, int resource, ArrayList<MonthlyModel> mArray) {
        super(context, resource);
        this.mArray = mArray;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mArray.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = mLayoutInflater.inflate(R.layout.item_monthly,parent,false);

        }

        mTextView = (TextView) convertView.findViewById(R.id.monthly);

        MonthlyModel mMonthlyModel = (MonthlyModel)getItem(position);

        mTextView.setText(mMonthlyModel.strBillName);

        return  convertView;
    }
}

