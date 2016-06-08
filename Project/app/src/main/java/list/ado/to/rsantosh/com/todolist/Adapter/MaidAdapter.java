package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.MaidModel;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 31-05-2016.
 */
public class MaidAdapter extends ArrayAdapter {

    private ArrayList<MaidModel> mMArray;
    private Context mContext;
    private LayoutInflater mLayoutInfalter;
    private TextView mTextView;

    public MaidAdapter(Context context, int resource, ArrayList<MaidModel> mMArray) {
        super(context, resource);
        this.mMArray = mMArray;
        this.mContext = context;
        this.mLayoutInfalter = mLayoutInfalter.from(mContext);
    }

    @Override
    public int getCount() {
        return mMArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mMArray.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){

            convertView = mLayoutInfalter.inflate(R.layout.format_maid,parent,false);

        }

        mTextView = (TextView) convertView.findViewById(R.id.maid_name);

        MaidModel mMaidModel = (MaidModel)getItem(position);

        mTextView.setText(mMaidModel.strName);

        return convertView;
    }
}
