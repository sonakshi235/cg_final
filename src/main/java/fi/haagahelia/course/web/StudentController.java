package fi.haagahelia.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.Course;
import fi.haagahelia.course.domain.CourseRepository;
import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;
import fi.haagahelia.course.domain.Video;
import fi.haagahelia.course.domain.VideoRepository;

@Controller
public class StudentController {
	@Autowired
    private StudentRepository repository; 

	@Autowired
    private CourseRepository crepository;
	
	@Autowired
    private VideoRepository vrepository;
	
	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	
	
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> students = (List<Student>) repository.findAll();
		model.addAttribute("students", students);
    	return "students";
    }
    
	
	@RequestMapping("/courses")
	public String index1(Model model) {
		List<Course> courses = (List<Course>) crepository.findAll();
		model.addAttribute("courses", courses);
    	return "courses";
    }

    @RequestMapping(value = "add")
    public String addStudent(Model model){
    	model.addAttribute("student", new Student());
        return "addStudent";
    }	
    @RequestMapping(value = "update")
    public String addCourse(Model model){
    	model.addAttribute("course", new Course());
        return "addCourse";
    }	
    @RequestMapping(value = "video")
    public String addVideo(Model model){
    	model.addAttribute("video", new Video());
        return "addVideo";
    }	

    @RequestMapping(value = "/edit/{id}")
    public String editStudent(@PathVariable("id") Long studentId, Model model){
    	model.addAttribute("student", repository.findById(studentId));
        return "editStudent";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Student student){
        repository.save(student);
    	return "redirect:/students";
    }
    @RequestMapping(value = "savec", method = RequestMethod.POST)
    public String save(Course course){
        crepository.save(course);
    	return "redirect:/students";
    }
    @RequestMapping(value = "savev", method = RequestMethod.POST)
    public String save(Video video){
        vrepository.save(video);
    	return "redirect:/students";
    }
    
    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
    	repository.deleteById(studentId);
        return "redirect:/students";
    }    
    
    @RequestMapping(value = "addStudentCourse/{id}", method = RequestMethod.GET)
    public String addCourse(@PathVariable("id") Long studentId, Model model){

    		model.addAttribute("courses", crepository.findAll());
    		model.addAttribute("student", repository.findById(studentId).get());
    		return "addStudentCourse";
    }
    @RequestMapping(value = "addCourseVideo/{courseid}", method = RequestMethod.GET)
    public String addVideo(@PathVariable("courseid") Long courseId, Model model){

    		model.addAttribute("videos", vrepository.findAll());
    		model.addAttribute("course", repository.findById(courseId).get());
    		return "addCourseVideo";
    }
    
    
    @RequestMapping(value="/student/{id}/courses", method=RequestMethod.GET)
	public String studentsAddCourse(@RequestParam(value="action", required=true) String action, @PathVariable Long id, @RequestParam Long courseId, Model model) {
    	Optional<Course> course = crepository.findById(courseId);
		Optional<Student> student = repository.findById(id);

		if (student.isPresent() && action.equalsIgnoreCase("save")) {
			if (!student.get().hasCourse(course.get())) {
				student.get().getCourses().add(course.get());
			}
			repository.save(student.get());
			model.addAttribute("student", crepository.findById(id));
			model.addAttribute("courses", crepository.findAll());
			return "redirect:/students";
		}

		model.addAttribute("developers", repository.findAll());
		return "redirect:/students";
		
	}    
    
    @RequestMapping(value = "getstudents", method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudents() {
            return (List<Student>)repository.findAll();
    }     
    @RequestMapping(value = "getcourses", method = RequestMethod.GET)
    public @ResponseBody List<Course> getCourses() {
            return (List<Course>)crepository.findAll();
    }     
}
