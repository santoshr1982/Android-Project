package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.DryCleaningModel;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 31-05-2016.
 */
public class DryCleaningAdapter extends ArrayAdapter {

    private ArrayList<DryCleaningModel> mDryList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private TextView mTextView;

    public DryCleaningAdapter(Context context, int resource, ArrayList<DryCleaningModel> mList) {
        super(context, resource);
        this.mDryList = mList;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDryList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView = mLayoutInflater.inflate(R.layout.item_drycleaning,parent,false);

        }

        mTextView = (TextView) convertView.findViewById(R.id.cloth_name);

        DryCleaningModel m = (DryCleaningModel)getItem(position);

        mTextView.setText(m.strNameOfCloth);

        return convertView;
    }
}
