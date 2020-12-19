package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem
{
    List<Feature> features = new ArrayList<>();
    int price;
    String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feat)
    {
        for(Feature f: feat)
        {
            features.add(f);
        }
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public List<Feature> getFeatures()
    {
        return features;
    }

    public int getPrice()
    {
        return price;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public List<String>  getContributors()
    {
        List <String> result = new ArrayList<>();
        for (Feature f : features) {
            result.addAll(f.getContributors());
        }
        return List.copyOf(result);
    }

    public List<String>  getTitles()
    {
        List <String> titles = new ArrayList<>();
        for (Feature f : features) {
            titles.add(f.getTitle());
        }
        return titles;
    }

    public int  fullLengthAtOneItem()
    {
        int sum = 0;
        for (int i= 0; i < features.size(); i++)
        {
            if (features.get(i) instanceof AudioFeatures)
            {
                sum = sum +  ((AudioFeatures) features.get(i)).getLength();
            }
        }
        return sum;
    }

    public boolean hasAudioFeature()
    {
        for (int i= 0; i < features.size(); i++)
        {
            if(features.get(i)  instanceof  AudioFeatures)
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature()
    {
        for (int i= 0; i < features.size(); i++)
        {
            if(features.get(i)  instanceof  PrintedFeatures)
            {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem()
    {
        int sum = 0;
        for (int i= 0; i < features.size(); i++)
        {
            if (features.get(i) instanceof  PrintedFeatures)
            {
                sum = sum + (((PrintedFeatures) features.get(i)).getNumberOfPages());
            }
        }
        return sum;
    }
}
