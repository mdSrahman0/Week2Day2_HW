# Week2Day2_HW

/**
 * Md Rahman
Create an app which is a directory for all the animals in a zoo.
        1. Activity one: Make a homepage for zoo information
        2. Activity two: ListView with list of all the categories.
        3. Activity three: RecyclerView with a list of all the animals in that category
        4. Activity four: Detail of that animal selected from the list.
        It should have the detail of that animal and play a sound of that animal.
*/

NOTE - Currently, only the listview activity works. 
MainActivity

        public class MainActivity extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
            }

            public void onClick(View view) {
                if(view.getId() == R.id.btCategory) {
                    Intent intent = new Intent(this, CategoryListViewActivity.class);
                    startActivity(intent);
                }
            } // end onClick
        } // end main activity
        
        
 CategoryListViewActivity
 
    public class CategoryListViewActivity extends AppCompatActivity {

    ListView lvCategory;
    RecyclerView rvAnimalRecyclerView;
    ArrayList<AnimalList> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list_view);

        lvCategory = findViewById(R.id.lvCategory);

        // Create a new ArrayList to hold categories of animals
        final ArrayList<String> myList = new ArrayList<>();
        myList.add("Land Animals");
        myList.add("Water Animals");

        // attach the arrayList to an adapter, and pass that adapter to the listview
        ArrayAdapter Adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);
        lvCategory.setAdapter(Adapter);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long l) {
                if(position == 1){
                    populateLandAnimalList();
                    callRecyclerView();
                    Intent intent = new Intent(getApplicationContext(), CategoryListViewActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(position == 2){
                    populateWaterAnimalList();
                    callRecyclerView();
                    Intent intent = new Intent(getApplicationContext(), CategoryListViewActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    } // end onCreate

    private void callRecyclerView() {
        rvAnimalRecyclerView = findViewById(R.id.rvAnimalRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AnimalRecyclerView animalRecyclerView = new AnimalRecyclerView();

        rvAnimalRecyclerView.setLayoutManager(layoutManager);
        rvAnimalRecyclerView.setAdapter(animalRecyclerView);
    }

    private void populateLandAnimalList(){
        animalList.add(new AnimalList("Cheetah", "0-60 faster than your secondhand civic"));
        animalList.add(new AnimalList("Dog","Abuse it and you answer to John Wick"));
        animalList.add(new AnimalList("Hyena", "Why are these idiots always laughing?"));
        animalList.add(new AnimalList("Dinosaur", "Yes I know they're extinct but they're still cool ok!"));
    }

    private void populateWaterAnimalList(){
        animalList.add(new AnimalList("Shark", "Kills less peoeple per year than cows"));
        animalList.add(new AnimalList("Dolphin", "Super smart, friendly, and definitely up to something"));
        animalList.add(new AnimalList("Stringray", "Why did they kill my boy Steve Irwin?"));
        animalList.add(new AnimalList("Lobster", "Why are you guys so expensive"));
    }
    } // end class
    
AnimalRecyclerView

    public class AnimalRecyclerView extends RecyclerView.Adapter<AnimalRecyclerView.ViewHolder> {

    public AnimalRecyclerView() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }
      public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View item) {
            super(item);
        }
      }
  }

        
