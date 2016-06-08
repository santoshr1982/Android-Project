package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.Details;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 29-05-2016.
 */
public class DetailsAdapter extends ArrayAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Details> mArray;
    private ImageView mImageVIew;
    private TextView mTextView;

    public DetailsAdapter(Context context, int resource, ArrayList<Details> mArray) {
        super(context, resource);
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mArray = mArray;
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

            convertView = mLayoutInflater.inflate(R.layout.details_item_list,parent,false);
        }

        mImageVIew = (ImageView) convertView.findViewById(R.id.image_icon);
        mTextView = (TextView) convertView.findViewById(R.id.to_do_name);

        Details mDetails = (Details)getItem(position);

        mImageVIew.setImageResource(mDetails.intImage);
        mTextView.setText(mDetails.strName);

        return convertView;
    }
}
