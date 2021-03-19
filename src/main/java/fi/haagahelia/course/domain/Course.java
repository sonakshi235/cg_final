package fi.haagahelia.course.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private long courseid;
	
    @Column(name="coursename")
	private String name; 
     
    @ManyToMany(mappedBy = "courses")    
    private Set<Student> students;  
    

    public Course() {
	}

	public Course(long courseid, String name) {
		super();
		this.courseid = courseid;
		this.name = name;
	}

	public Course(String name) {
		this.name = name;
	}     

    public long getCourseid() {
		return courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
    
    
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }	
    @ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "course_video", joinColumns = { @JoinColumn(name = "courseid") }, inverseJoinColumns = { @JoinColumn(name = "videoid") })
    private Set<Video> videos=new HashSet<Video>(0);
    public Set<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	
	public boolean hasVideo(Video video) {
		for (Video courseVideo: getVideos()) {
			if (courseVideo.getVideoid() == video.getVideoid()) {
				return true;
			}
		}
		return false;
	}	
}
