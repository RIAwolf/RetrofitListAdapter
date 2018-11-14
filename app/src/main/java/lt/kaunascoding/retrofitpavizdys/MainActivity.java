package lt.kaunascoding.retrofitpavizdys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import lt.kaunascoding.retrofitpavizdys.controllers.RecipeAdapter;
import lt.kaunascoding.retrofitpavizdys.model.entities.RecipeVO;
import lt.kaunascoding.retrofitpavizdys.model.services.RecipesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL = "http://192.168.0.99:8080";

    // su * daryti tik viena karta
    // 1* isideti retrofit gradle biblioteka
    // 1.1* isideti gradle converter biblioteka
    // 2 Susikurti VO klase
    // 3 Susikurti Interface servisui
    // 4 Susikurti retrofit objekta
    // 5 kreiptis i interneta duomenu
    // 6 perduoti duomenis i list adapateri
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kraukDuomenis();
    }

    public void kraukDuomenis() {

        // punktas 3
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // punktas 4
        RecipesService recipesService = retrofit.create(RecipesService.class);
        // punktas 5
        Call<List<RecipeVO>> callVisi = recipesService.getAllRecipes();
        callVisi.enqueue(new Callback<List<RecipeVO>>() {
            @Override
            public void onResponse(Call<List<RecipeVO>> call, Response<List<RecipeVO>> response) {
                // punktas 6

                uzpildykSarasa(response.body());

            }

            @Override
            public void onFailure(Call<List<RecipeVO>> call, Throwable t) {

            }
        });

        Call<RecipeVO> callVienas = recipesService.getRecipe(3);
        callVienas.enqueue(new Callback<RecipeVO>() {
            @Override
            public void onResponse(Call<RecipeVO> call, Response<RecipeVO> response) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<RecipeVO> call, Throwable t) {

            }
        });
    }

    public void uzpildykSarasa(List<RecipeVO> receptai) {

        RecipeAdapter adapter = new RecipeAdapter(this, receptai);
        ListView recipeList = (ListView) findViewById(R.id.recipeList);
        recipeList.setAdapter(adapter);

    }
}
