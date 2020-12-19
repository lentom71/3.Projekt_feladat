package catalog;


import java.util.List;

public class Validators
{
    public static boolean isBlank(String szoveg)
    {
        if (szoveg == null || szoveg.isBlank())
        {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List lista)
    {
        if (lista == null || lista.isEmpty())
        {
            return true;
        }
        return false;
    }
}
