package uitilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidUserData")
    public static Object invalidCredentials(){
        Object[][] data = {{"standard_user", "secret_", "Epic sadface: Username and password do not match any user in this service" },
                {"standard_", "secret_sauce", "Epic sadface: Username and password do not match any user in this service" },
                {"", "secret_sauce", "Epic sadface: Username is required" },
                {"standard_user", "", "Epic sadface: Password is required" },
                {"", "", "Epic sadface: Username is required" },
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out." }
            };

        return data;
    }
}
