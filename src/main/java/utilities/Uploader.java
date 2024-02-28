package utilities;

import java.io.File;
import java.nio.file.Paths;

public class Uploader {
    public static String getUploadDirectory() {
        return Paths.get(System.getProperty("user.dir"), ConfProperties.getProperty("upload_path")).toString();
    }

    public static String getUploadTargetDirectory() {
        return Paths.get(System.getProperty("user.dir"), ConfProperties.getProperty("target_upload_path")).toString();
    }

    public static File getDirectory() {
        return new File(getUploadTargetDirectory());
    }

    public static void createUploadFolder() {
        if (!getDirectory().exists()) {
            getDirectory().mkdir();
        }
    }
}
