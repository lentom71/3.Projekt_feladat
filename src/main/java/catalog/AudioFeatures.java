package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioFeatures implements Feature
{
    List<String> composers;
    int length;
    List<String> performers;
    String title;

    public AudioFeatures(String title,  int length,  List<String> performers,  List<String> composers)
    {
        this.composers = composers;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers)
    {
        if (length < 0  ||  title == ""   ||   performers ==  null)
        {
            throw new IllegalArgumentException("Rossz paraméter");
        }
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public List<String> getContributors()
    {
        List<String> result = new ArrayList<>();
        if ((composers!=null))
        {
            result.addAll(composers);
        }
        result.addAll(performers);
        return List.copyOf(result);
    }

    public String getTitle()
    {
        return title;
    }

    public int getLength()
    {
        return length;
    }
}
