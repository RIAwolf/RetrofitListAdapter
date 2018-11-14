package lt.kaunascoding.retrofitpavizdys.model.services;

import java.util.List;
import java.util.Optional;

import lt.kaunascoding.retrofitpavizdys.model.entities.RecipeVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RecipesService {
    @GET("/recipes/all")
    Call<List<RecipeVO>> getAllRecipes();

    @GET("/recipes/{id}")
    Call<RecipeVO> getRecipe(@Path("id") int id);


}
