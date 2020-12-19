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
        int szamlalo = 0;
        int sum = 0;
        double atlag = 0;
        for (int i=0; i < catalogItems.size(); i++)
        {
            if(catalogItems.get(i).hasPrintedFeature())
            {
                for(int j = 0; j < catalogItems.get(i).features.size(); j++)
                {
                    if (catalogItems.get(i).features.get(j) instanceof PrintedFeatures)
                    {
                        sum = sum + ((PrintedFeatures) catalogItems.get(i).features.get(j)).numberofPages;
                        szamlalo++;
                    }
                }
                atlag = sum/szamlalo;
                if (atlag > page)
                {
                    return atlag;
                }
            }
        }
        return 0;
    }


    public List<CatalogItem>  findByCriteria(SearchCriteria search)
    {
        List<CatalogItem> listamind2 = new ArrayList<>();
        List<CatalogItem> listaContributors = new ArrayList<>();
        List<CatalogItem> listaTitles = new ArrayList<>();

            if(search.hasContributor()  &&  search.hasTitle())
            {
                for (int i = 0; i < catalogItems.size(); i++)
                {
                    for (int j = 0; j < catalogItems.get(i).getFeatures().size(); i++)
                    {
                        if (search.getContributor().equals(catalogItems.get(i).getFeatures().get(j).getContributors())
                                                                 &&
                                search.getTitle().equals(catalogItems.get(i).getFeatures().get(j).getTitle())) ;
                        {
                            listamind2.add(catalogItems.get(i));
                        }
                    }
                }
            }

            if(search.hasContributor())
            {
                for (int i = 0; i<catalogItems.size(); i++)
                {
                    for (int j = 0; j < catalogItems.get(i).getFeatures().size(); i++)
                    {
                        if (search.getContributor().equals(catalogItems.get(i).getFeatures().get(j).getContributors()))
                        {
                            listaContributors.add(catalogItems.get(i));
                        }
                    }
                }
            }

            if (search.hasTitle())
            {
                for (int i = 0; i<catalogItems.size(); i++)
                {
                    for (int j = 0; j < catalogItems.get(i).getFeatures().size(); i++)
                    {
                        if (search.getContributor().equals(catalogItems.get(i).getFeatures().get(j).getContributors()))
                        {
                            listaTitles.add(catalogItems.get(i));
                        }
                    }
                }
            }

            if((search.hasContributor()  &&  search.hasTitle()))
            {
                return listamind2;
            }
            if((search.hasContributor()))
            {
                return listaContributors;
            }
            else
            {
                return listaTitles;
            }
    }
}

