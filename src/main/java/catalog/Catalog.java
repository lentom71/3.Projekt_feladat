package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog
{
    ArrayList<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem cat)
    {
        catalogItems.add(cat);
    }

    public void deleteItemByRegistrationNumber(String regi)
    {
        for (int i = 0; i<catalogItems.size(); i++)
        {
            if(catalogItems.get(i).getRegistrationNumber() == regi)
            {
                catalogItems.remove(i);
            }
        }
    }

    public int  getAllPageNumber()
    {
        int  sum = 0;
        for (int i = 0; i<catalogItems.size(); i++)
        {
            if (catalogItems.get(i).hasPrintedFeature())
            {
                sum = sum + catalogItems.get(i).numberOfPagesAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryitems()
    {
        List<CatalogItem>  audiolista = new ArrayList<>();
        for (int i = 0; i<catalogItems.size(); i++) {
            if (catalogItems.get(i).hasAudioFeature()) {
                audiolista.add(catalogItems.get(i));
            }
        }
        return audiolista;
    }

    public int  getFullLength()
    {
        int  sum = 0;
        for (int i = 0; i<catalogItems.size(); i++)
        {
            if (catalogItems.get(i).hasAudioFeature())
            {
                sum = sum + catalogItems.get(i).fullLengthAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryitems()
    {
       List<CatalogItem>  nyomtatottlista  =  new ArrayList<>();
            for (int i = 0; i<catalogItems.size(); i++)
            {
                if (catalogItems.get(i).hasPrintedFeature())
                {
                    nyomtatottlista.add(catalogItems.get(i));
                }
            }
       return nyomtatottlista;
    }


    public double averagePageNumberOver(int page)
    {
        if (page < 1 )
        {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int sum = 0;
        int szamlalo = 0;
        double atlag = 0;
        for (CatalogItem catalogItem : catalogItems)
        {
            if (catalogItem.hasPrintedFeature() && catalogItem.numberOfPagesAtOneItem() > page)
            {
                sum = sum + catalogItem.numberOfPagesAtOneItem();
                szamlalo = szamlalo + 1;
            }
        }
        atlag = sum / szamlalo;
        if (atlag > page)
        {
            return atlag;
        }
        throw new IllegalArgumentException("No page");
    }


    public List<CatalogItem> findByCriteria(SearchCriteria search)
    {
        List<CatalogItem> results = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems)
        {
            if  (search.hasContributor() && catalogItem.getContributors().contains(search.getContributor())
                    &&
                    search.hasTitle() && catalogItem.getTitles().contains(search.getTitle()))
            {
                results.add(catalogItem);
            }
            else if (search.hasContributor() && catalogItem.getContributors().contains(search.getContributor()))
            {
                results.add(catalogItem);
            }
            else if (search.hasTitle() && catalogItem.getTitles().contains(search.getTitle()))
            {
                results.add(catalogItem);
            }
        }
        return results;
    }
}

