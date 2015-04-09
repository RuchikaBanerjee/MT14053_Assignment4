package demo;

import java.io.Serializable;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }
}

@RestController
//@RequestMapping(value = "/file")
class UploadFile{
	
	public File f = new File("Ruchika");
	
	@RequestMapping(value = "/file", method= RequestMethod.GET)
	@PreAuthorize("hasRole('User')")
	public String getFileList(){
		
		//File f = new File("Ruchikaiiiiii");
		String s = f.getname();
		return s;
		
	}
	
	@RequestMapping(value = "/postfile", method= RequestMethod.POST)
	@PreAuthorize("hasRole('User')")
	public String addFile(@RequestParam String s){
		
		//File f = new File("Ruchika Banerjee");
		//File f = new File("oyeee");
		String s2 = f.setname("oooooooo");
		return s2;
		
	}
	
	@RequestMapping(value = "/upload", method= RequestMethod.GET)
	@PreAuthorize("hasRole('User')")
	public String UploadFile(){
		
		File f = new File("Ruchika Banerjee");
		String s = f.getname();
		return s;
		
	}
	
	@RequestMapping(value = "/delete", method= RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public String DeleteFile(){
		
		File f = new File("Ruchika Banerjee");
		String s = f.getname();
		return s;
		
	}
	
	
}

/*@RestController
class VideoAppController
{
	public Vector<VideoList> videos = new Vector<VideoList>();
	
	@RequestMapping(value = "/getvideo", method = RequestMethod.GET)
	public Vector<VideoList> fetchVideo() 
	{  

		if(videos.size() == 0)
		{
			/*Vector<VideoList> no_video = new Vector<VideoList>();
			VideoList no_v = new VideoList("No Videos found", null, null, null);
			no_video.add(no_v);
			return no_video;*/
			
			/*return null;
		}
		
		return videos;
	}
	
	
	@RequestMapping(value = "/postvideo" , method = RequestMethod.POST)
	public String postVideo(@RequestParam String name, @RequestParam String uploader, @RequestParam String duration, @RequestParam String likes)
	{
		VideoList new_video = new VideoList();
		new_video.setName(name);
		new_video.setUploader(uploader);
		new_video.setDuration(duration);
		new_video.setLikes(likes);
		
		videos.add(new_video);
		
		return "Video Successfully Added";
		

	}
	
	@RequestMapping(value = "/putvideo" , method = RequestMethod.POST)
	public String putVideo(@RequestBody VideoList v )
	{
		
		videos.add(v);
		
		return "Video Successfully Added";
		

	}
	
	@RequestMapping(value = "/searchvideo/{str}" , method = RequestMethod.GET)
	public VideoList searchVideo(
		@PathVariable("str")	String searchQuery
		)
	{	
		int flag =0;
		for (int i=0;i<videos.size();i++){
			VideoList temp = videos.get(i);
			if(temp.getName().equals(searchQuery)){
				flag=1;
				return temp;
			}
		
		}
	
		
		//return new VideoList("Video Not Found!",null,null,null);
		return null;
	}
	
}*/


class File{
	
	public String file_name;
	
	File(String file_name){
		this.file_name = file_name;
	}
    public String getname(){
    	
    	return this.file_name;
    }
    public String setname(String s){
    	this.file_name = s;
    	return s;
    	
    }
	
	
}

/*class VideoList 
{   
	
	
	
	public String name, uploader, duration, likes;
	public VideoList() {}
	
	public VideoList(String name,String uploader,String duration,String likes){
		this.name = name;
		this.uploader = uploader;
		this.duration = duration;
		this.likes = likes;
	}
	
	
	public String getName()
	{
	 return this.name;
	}
	
	public String getUploader()
	{
	 return this.uploader;
	}
	
	public String getDuration()
	{
	 return this.duration;
	}
	
	public String getLikes()
	{
	 return this.likes;
	}
	
	public void setName(String msg)
	{
		this.name = msg;
	}
	
	public void setUploader(String msg)
	{
		this.uploader = msg;
	}
	
	public void setDuration(String msg)
	{
		this.duration = msg;
	}
	
	public void setLikes(String msg)
	{
		this.likes = msg;
	}
}*/