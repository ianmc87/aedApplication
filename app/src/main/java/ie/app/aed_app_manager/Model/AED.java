package ie.app.aed_app_manager.Model;

public class AED
{
    public String id;
    public String location;
    public String condition;
    public String date;

    public AED (String id, String location, String condition, String date)
    {
        this.id = id;
        this.location = location;
        this.condition = condition;
        this.date = date;
    }

    @Override
    public String toString() {
        return "AED{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", condition='" + condition + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
