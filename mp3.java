import java.io.*;
import java.util.*;
import java.net.*;

class mp3{
    public void saveUrl(final String filename, final String urlString) throws MalformedURLException, IOException {
    BufferedInputStream in = null;
    FileOutputStream fout = null;
    try {
        in = new BufferedInputStream(new URL(urlString).openStream());
        fout = new FileOutputStream(filename);

        final byte data[] = new byte[1024];
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
            fout.write(data, 0, count);
        }
    } finally {
        if (in != null) {
            in.close();
        }
        if (fout != null) {
            fout.close();
        }
            System.out.println("Successfully downloaded!! \n");
    }
}

public static void main(String[] args) throws Exception {
    mp3 obj=new mp3();
    obj.saveUrl("The_Chain_Smokers_Closer_Tyson_Baker_Bootleg_Kick.mp3","http://s4.mp3yox.com/d/076/278076060sc.mp3?t=aLif5mEpNelyJ7XqXahWFQ&e=1480552215&name=The_Chain_Smokers_Closer_Tyson_Baker_Bootleg_Kick");
}

}