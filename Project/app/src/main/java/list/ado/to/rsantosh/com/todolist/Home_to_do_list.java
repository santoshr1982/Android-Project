package list.ado.to.rsantosh.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Adapter.ToDoAdapter;
import list.ado.to.rsantosh.com.todolist.Model.ToDoList;

public class Home_to_do_list extends AppCompatActivity {

    private ArrayList<ToDoList> mTodoList;
    private ToDoAdapter mTda;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_to_do_list);

        mTodoList = getmTodoList();
        mTda = new ToDoAdapter(getApplicationContext(),R.layout.item_house_hold,mTodoList);
        mGridView = (GridView) findViewById(R.id.home_grid_view);
        mGridView.setAdapter(mTda);

        registerForContextMenu(mGridView);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){


                    case 0:

                            Intent Next = new Intent(getApplicationContext(),DetailsActivity.class);
                            startActivity(Next);
                            break;

                    case 1:

                            Intent iNext = new Intent(getApplicationContext(),MonthlyToDoList.class);
                            startActivity(iNext);
                            break;

                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.add_menu :
                Toast.makeText(getApplicationContext(), "" + item, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.help_menu :
                Toast.makeText(getApplicationContext(), "" + item, Toast.LENGTH_SHORT).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("pls choose one");

        menu.add(1,100,1,"new");
        menu.add(1,101,2,"delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case 100:
                Toast.makeText(getApplicationContext(),"" + item,Toast.LENGTH_SHORT).show();
                return true;

            case 101:
                Toast.makeText(getApplicationContext(),"" + item,Toast.LENGTH_SHORT).show();
                return true;


        }

        return super.onContextItemSelected(item);
    }

    public ArrayList<ToDoList> getmTodoList() {

        mTodoList = new ArrayList<>();

        mTodoList.add(new ToDoList(R.drawable.home,"House Hold To Do List"));
        mTodoList.add(new ToDoList(R.drawable.todolist,"Monthly To Do List"));
        mTodoList.add(new ToDoList(R.drawable.todolist,"Monthly To Do List"));

        return mTodoList;
    }
}
