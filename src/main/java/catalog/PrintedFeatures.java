package catalog;

import catalog.Feature;

import java.util.List;

public class PrintedFeatures implements Feature
{
    List<String>  authors;
    int numberofPages;
    String title;

    public PrintedFeatures(String title, int numberofPages, List<String> authors)
    {
        if (title == "" )
        {
            throw new IllegalArgumentException("Empty title");
        }

        if (numberofPages > Integer.MAX_VALUE   ||   numberofPages < 1   ||   authors ==  null)
        {
            throw new IllegalArgumentException("Rossz paraméter");
        }

        this.authors = authors;
        this.numberofPages = numberofPages;
        this.title = title;
    }

    public int getNumberOfPages()
    {
        return numberofPages;
    }

    public String getTitle()
    {
        return title;
    }

    public List<String> getContributors()
    {
        return  List.copyOf(authors);
    }
}
