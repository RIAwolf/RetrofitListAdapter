package lt.kaunascoding.retrofitpavizdys.model.entities;

public class RecipeVO {
    public int id;
    public String name;
    public String description;


    @Override
    public String toString() {
        return "id: " + id + " name:" + name + " description: " + description;
    }
}
