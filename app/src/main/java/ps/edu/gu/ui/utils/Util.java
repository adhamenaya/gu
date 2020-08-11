package ps.edu.gu.ui.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Util {

    public static File readPDF(Context ctx, int res_id) {
        File tempFile = null;
        try {
            InputStream is = ctx.getResources().openRawResource(res_id);
            tempFile = File.createTempFile("temp", "PDF");
            tempFile.deleteOnExit();
            OutputStream os = new FileOutputStream(tempFile);
            copyStream(is,os);

            is.close();
            os.close();
         } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
    }

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
