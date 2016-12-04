//this program gives the href links to all the songs which have lyrics "shadow in the background of the morgue"

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class downloadLyricFirstPage{

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);

		String lyric=in.nextLine();
		String formattedLyric1=lyric.replaceAll(" ","%20");
		String formattedLyric=formattedLyric1.replaceAll("'","&#039;");
		
		System.out.println("the formatted lyrics is :"+formattedLyric );
		String first_url="/watch?v=ih2xubMaZWI";
		String url="http://www.lyrics.com/lyrics/"+lyric;
		
		String finalurl="";
		ArrayList<String> arr=new ArrayList<String>();

		Document sd=Jsoup.connect( url ).timeout(6000).get();
		Elements ele2=sd.select("div.col-xs-12.col-sm-12");
		//int count=0,flag=0;
		//Element element2;
		//=ele2.select("p.download-buttons.fullWidth");
		for (Element element2 : ele2.select("div.sec-lyric.clearfix")) {
			System.out.println("inside for loop");
			//String download_url=element.select("p.download-buttons.fullWidth").attr("href");
				//System.out.println(download_url);
			finalurl=element2.select("a").text();
			arr.add(finalurl);
			
			System.out.println("the link : " +finalurl);
			
			System.out.println(element2.select("a").attr("href"));
		}



		System.out.println(Arrays.toString(arr.toArray()));
		
		System.out.println("select the position in the list to be downloaded ");
		int pos=in.nextInt();



		String [] token = arr.get(pos).split("\\s+"); 
         //Splits words & assign to the token[]  ex : token[0] -> Copying ,token[1] -> first


        int N=3; // NUMBER OF WORDS THAT YOU NEED
        String nWords="";

        // concatenating number of words that you required
        for(int i=0; i<N ; i++){
             nWords = nWords + " " + token[i] ;         
        }

		Document d=Jsoup.connect("https://www.youtube.com/results?search_query="+nWords).timeout(6000).get();
		Elements ele=d.select("ol.item-section");
		int count=0,flag=0;
		String first_url1="https://www.youtube.com/results?search_query="+nWords;
		//String first_songname;
		for (Element element : ele.select("li")) {
			String download_url=element.select("a.yt-uix-sessionlink.spf-link").attr("href");
				//System.out.println(download_url);
			
			count++;
			if(flag==0){
				if(download_url.indexOf("/watch?") != -1){
				first_url1=download_url;
				System.out.println(first_url1);
				flag=1;
				System.out.println("Result found at position :"+ count);
				}
			}
			
//			String title=element.select("b").text();
//			//System.out.println(title);
//			if(count==1){
//				first_songname = title;
//			}
		}
		String url2="http://www.youtubeinmp3.com/fetch/?video=https://www.youtube.com"+first_url1;

		System.out.println(url2);

		mp3 obj=new mp3();
		obj.saveUrl(arr.get(pos)+".mp3",url2);



		
		
	}

}
