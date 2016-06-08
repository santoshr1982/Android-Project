package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.DisplayEditDelete;
import list.ado.to.rsantosh.com.todolist.Model.ListDetails;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 30-05-2016.
 */
public class DisplayAdapter extends ArrayAdapter {

    //Declaration Section.
    //Variable for Context.
    private Context mContext;
    //Variable for Layout Inflater.
    private LayoutInflater mLayoutInflater;
    //Variable for array list.
    private ArrayList<ListDetails> mArray;
    //Variable for text view.
    private TextView mTextView;


    //Constructor.
    public DisplayAdapter(Context context, int resource,ArrayList<ListDetails> mArray) {
        super(context, resource);
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mArray = mArray;
    }

    //Overriding method to get the length of the array list whic is returned.
    @Override
    public int getCount() {
        return mArray.size();
    }

    //Overriding the method to get the position of the cursor in the array list.
    @Override
    public Object getItem(int position) {
        return mArray.get(position);
    }

    //This code is written to populate the list view.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Checking if the convert view is null.
        if(convertView == null){

            //This code will stop populating the list view if convert view is null.
            convertView = mLayoutInflater.inflate(R.layout.item_display,parent,false);

        }

        //Initialisation of text view.
        mTextView = (TextView) convertView.findViewById(R.id.product_name1);

        //Creating object of ListDetails model.
        ListDetails Ded = (ListDetails) getItem(position);

        //Setting the value from array list into text box.
        mTextView.setText((Ded.getStrProductName()));

        //Returning ConvertView Value.
        return convertView;
    }
}
