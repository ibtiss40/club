package adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.DimancheF;
import fragments.JeudiF;
import fragments.MardiF;
import fragments.MercrediF;
import fragments.SamediF;
import fragments.VendrediF;
import fragments.lundiF;

public class pageAdapter extends FragmentPagerAdapter {

    public pageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new lundiF();
        else if (position == 1)
            fragment = new MardiF();
        else if (position == 2)
            fragment = new MercrediF();
        else if (position == 3)
            fragment = new JeudiF();
        else if (position == 4)
            fragment = new VendrediF();
        else if (position == 5)
            fragment = new SamediF();
        else if (position == 6)
            fragment = new DimancheF();

        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: //Page number 1
                return "Lundi";
            case 1: //Page number 2
                return "Mardi";
            case 2: //Page number 3
                return "Mercredi";
            case 3: //Page number 3
                return "Jeudi";
            case 4: //Page number 3
                return "Vendredi";
            case 5: //Page number 3
                return "Samedi";
            case 6: //Page number 3
                return "Dimanche";
            default:
                return null;
        }
    }
}
