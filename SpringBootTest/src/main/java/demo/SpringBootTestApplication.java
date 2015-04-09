package demo;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	public PDFFile f = new PDFFile("Ruchika");
	
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
		//if(file!=null){
			//System.out.println("Successfully received");
			//System.out.println(file.toString());
		//}
		//File f = new File("oyeee");
		//String s2 = f.setname("oooooooo");
		return s;
		
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	@PreAuthorize("hasRole('User')")
	public @ResponseBody String UploadFile(@RequestParam("name") String s, @RequestParam("pwd") String pwd){
		
		//VideoUserDetailsService v = new VideoUserDetailsService();
		
		//UserDetails text = v.loadUserByUsername(name);
		
		return pwd;
		
       
		/*File f = new File("Ruchika Banerjee");
		String s = f.getname();
		return s;*/
		
	}
	
	@RequestMapping(value = "/sendfile", method= RequestMethod.POST)
	@PreAuthorize("hasRole('User')")
	public @ResponseBody String SendFile(@RequestBody String file){
		
		//PDFFile f = new PDFFile("Ruchika Banerjee");
		String s = file.toString();
		return s;
		
	}
	
	
}

/*@Service("videoUserDetailsService")
class VideoUserDetailsService implements UserDetailsService {

	 protected final Log logger = LogFactory.getLog(getClass());
     
	    @Override
	    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	         
	        logger.info("loadUserByUsername username="+username);
	          
	        if(username.equals("rohit")){
	            return new UserDetails() {
		             
		           //private static final long serialVersionUID = 2059202961588104658L;
		 
		            @Override
		            public boolean isEnabled() {
		                return true;
		            }
		             
		            @Override
		            public boolean isCredentialsNonExpired() {
		                return true;
		            }
		             
		            @Override
		            public boolean isAccountNonLocked() {
		                return true;
		            }
		             
		            @Override
		            public boolean isAccountNonExpired() {
		                return true;
		            }
		             
		            @Override
		            public String getUsername() {
		                return username;
		            }
		             
		            @Override
		            public String getPassword() {
		                return "mehra";
		            }
		             
		            @Override
		            public Collection<? extends GrantedAuthority> getAuthorities() {
		                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
		                auths.add(new SimpleGrantedAuthority("Admin"));
		                return auths;
		            }
		        };
	        
	        }
	        else if(username.equals("rahul"))
	        {
	 	            return new UserDetails() {
	 		             
	 		            //private static final long serialVersionUID = 2059202961588104658L;
	 		 
	 		            @Override
	 		            public boolean isEnabled() {
	 		                return true;
	 		            }
	 		             
	 		            @Override
	 		            public boolean isCredentialsNonExpired() {
	 		                return true;
	 		            }
	 		             
	 		            @Override
	 		            public boolean isAccountNonLocked() {
	 		                return true;
	 		            }
	 		             
	 		            @Override
	 		            public boolean isAccountNonExpired() {
	 		                return true;
	 		            }
	 		             
	 		            @Override
	 		            public String getUsername() {
	 		                return username;
	 		            }
	 		             
	 		            @Override
	 		            public String getPassword() {
	 		                return "kohli";
	 		            }
	 		             
	 		            @Override
	 		            public Collection<? extends GrantedAuthority> getAuthorities() {
	 		                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
	 		                auths.add(new SimpleGrantedAuthority("User"));
	 		                return auths;
	 		            }
	 		        };
	 	        
	        }
	        else
	        {
	        	throw new UsernameNotFoundException(username + " not found");
	        }
	        
			
	         
	    }
	}*/

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


class PDFFile{
	
	public String file_name;
	
	PDFFile(String file_name){
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