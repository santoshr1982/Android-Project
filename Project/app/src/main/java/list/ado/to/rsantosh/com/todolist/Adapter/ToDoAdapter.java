package list.ado.to.rsantosh.com.todolist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.ToDoList;
import list.ado.to.rsantosh.com.todolist.R;

/**
 * Created by C S Ramachandran on 21-05-2016.
 */
public class ToDoAdapter extends ArrayAdapter{

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ToDoList> mArray;
    private ImageView mImageView;
    private TextView mTextView;

    public ToDoAdapter(Context context, int resource, ArrayList<ToDoList> mArray) {
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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = mLayoutInflater.inflate(R.layout.item_house_hold,parent,false);
        }

        mImageView = (ImageView) convertView.findViewById(R.id.house_hold_icon);
        mTextView = (TextView) convertView.findViewById(R.id.house_hold_name);

        ToDoList mToDoList = (ToDoList)getItem(position);

        mImageView.setImageResource(mToDoList.mImage);
        mTextView.setText(mToDoList.mName);

        return  convertView;
    }
}
