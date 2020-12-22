package catalog;

public class SearchCriteria
{
    public static String contributor;
    public static String title;

    public SearchCriteria(String contributor, String title)
    {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor()
    {
        return contributor;
    }

    public String getTitle()
    {
        return title;
    }

    boolean hasContributor()
    {
        if (contributor != null)
        {
            return true;
        }
        return false;
    }

    boolean  hasTitle()
    {
        if (title != null)
        {
            return true;
        }
        return false;
    }

    public static SearchCriteria  createByContributor(String contributor)
    {
        if(contributor  ==  null)
        {
            throw new IllegalArgumentException("Nem lehet üres  a  Cim");
        }
        return new SearchCriteria(contributor, null);

    }

    public static SearchCriteria  createByTitle(String  title)
    {
        if(title  == null)
        {
            throw new IllegalArgumentException("Nem lehet üres  a  Szerzó");
        }
        return new SearchCriteria(null, title);
    }

    public static SearchCriteria  createByBoth(String title,  String contributor)
    {
        if(contributor == null ||  title ==  null)
        {
            throw new IllegalArgumentException("Nem lehet üres  a  Szerzó  vagy  a  Cim");
        }
        return new SearchCriteria(contributor, title);
    }
}
