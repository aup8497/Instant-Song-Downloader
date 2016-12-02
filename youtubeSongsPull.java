import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class youtubeSongsPull {

	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(System.in);
		System.out.print("enter the name of the song which you want to download : ");
		String songName=in.nextLine();
		songName.replaceAll("\\s","+");
		System.out.println("the formatted string is :"+songName);
		Document d=Jsoup.connect("https://www.youtube.com/results?search_query="+songName).timeout(6000).get();
		Elements ele=d.select("ol.item-section");
		int count=0;
		String first_url="https://www.youtube.com/results?search_query="+songName;
		//String first_songname;
		for (Element element : ele.select("li")) {
			String download_url=element.select("a.yt-uix-sessionlink.spf-link").attr("href");
				//System.out.println(download_url);
			
			count++;
			if(count==2){
				first_url=download_url;
				System.out.println(first_url);
			}
			
//			String title=element.select("b").text();
//			//System.out.println(title);
//			if(count==1){
//				first_songname = title;
//			}
		}
		String url="http://www.youtubeinmp3.com/fetch/?video=https://www.youtube.com"+first_url;

		mp3 obj=new mp3();
		obj.saveUrl(songName+".mp3",url);

		
	}

}
