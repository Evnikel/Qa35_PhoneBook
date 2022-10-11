package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> datalogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"evnikel@gmail.com", "Elena1234$@"});
        list.add(new Object[]{"evnikel2346@gmail.com", "Elena1234$@"});
        list.add(new Object[]{"evnikel2347@gmail.com", "Elena1234$@"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataModelUser() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@")});
        list.add(new Object[]{new User().withEmail("evnikel2346@gmail.com").withPassword("Elena1234$@")});
        list.add(new Object[]{new User().withEmail("evnikel2347@gmail.com").withPassword("Elena1234$@")});


        return list.iterator();
    }
}
