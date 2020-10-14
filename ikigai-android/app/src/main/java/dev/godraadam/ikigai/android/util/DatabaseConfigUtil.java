package dev.godraadam.ikigai.android.util;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt");
    }
}
