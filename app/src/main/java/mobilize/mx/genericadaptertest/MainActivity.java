package mobilize.mx.genericadaptertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import mobilize.mx.genericadapter.Adapter;
import mobilize.mx.genericadapter.ItemListener;
import mobilize.mx.genericadaptertest.model.Person;
import mobilize.mx.genericadaptertest.model.Posts;

public class MainActivity extends AppCompatActivity implements ItemListener {
    private List<Posts> postsList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private Adapter adapter;
    private Adapter adapterPersons;
    private RecyclerView rvPosts;
    private RecyclerView rvPersons;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateData();
        setUpRecycler();
    }

    private void setUpRecycler() {
        rvPosts = findViewById(R.id.rvPosts);
        rvPersons = findViewById(R.id.rvPersons);
        btnChange = findViewById(R.id.btnChange);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this);
        rvPersons.setLayoutManager(layoutManager1);
        /**
         * You can set up the adapter for (Post)"model":
         */
        adapter = new Adapter<>(postsList, R.layout.item_post, this, BR.model);
        rvPosts.setAdapter(adapter);

        /**
         * or Persons
         */
        adapterPersons = new Adapter<>(personList, R.layout.item_person, this, BR.person);
        rvPersons.setAdapter(adapterPersons);
        /*
        Change on runtime the layout for the adapter
         */
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterPersons.setLayoutId(R.layout.item_person_other_layout);
                adapterPersons.notifyDataSetChanged();
            }
        });



    }

    private void populateData() {
        populatePersons();
        populatePosts();
    }

    private void populatePersons() {
        Person person1 = new Person();
        person1.setAge(18);
        person1.setName("John");

        Person person2 = new Person();
        person2.setAge(36);
        person2.setName("Paul");

        Person person3 = new Person();
        person3.setAge(24);
        person3.setName("Rosa");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }

    private void populatePosts() {
        Posts post1 = new Posts();
        post1.setId(1);
        post1.setTitle("Title 1");
        Posts post2 = new Posts();
        post2.setId(2);
        post2.setTitle("Title 2");
        Posts post3 = new Posts();
        post3.setId(3);
        post3.setTitle("Title 3");

        postsList.add(post1);
        postsList.add(post2);
        postsList.add(post3);
    }

    /**
     * Implements onClick from Adapter Interface.
     *
     * @param model
     */
    @Override
    public void onClick(Object model, View v, int position) {
        /**
         * What kind of model expect you receive in this method?
         * According to the type of model you're passing to the adapter it's the type that you receiving here:
         */
        Log.d("MainActivity","Position:" + position);
        if (model instanceof Posts) {
            Log.d("MainActivity", "Post: " + ((Posts) model).id + " - " + ((Posts) model).title);
        } else if (model instanceof Person) {
            Log.d("MainActivity", "Person: " + ((Person) model).Name + " - " + ((Person) model).Age);
        }
    }
}
